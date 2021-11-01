package com.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.screens.databinding.ActivityProductOptionBinding;
import com.screens.models.OptionsItem;
import com.screens.models.ProductOptionItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ProductOptionActivity extends AppCompatActivity {

    ActivityProductOptionBinding binding;

    private List<ProductOptionItem> productOptions = new ArrayList<>();
    private ProductAdapter productAdapter;
    private JSONArray response = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductOptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getProducts();

        binding.btnApply.setOnClickListener(v -> {
            if (productAdapter != null) {
                try {
                    response = new JSONArray(productAdapter.prods.toString());
                    Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Log.e("TAG", "onCreate: ", e);
                }
            }
        });
    }

    public void getProducts() {
        binding.progressCircular.show();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://www.odmon2.co.uk/api/getOptionsByProducts/5151";
        JSONObject payload = new JSONObject();
        try {
            payload.put("order_id", 5244);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                payload, response -> {
            Log.d("TAG", "getProducts: " + response);
            binding.progressCircular.hide();
            try {
                JSONObject object = new JSONObject(response.toString());
                if (object.getString("status").equalsIgnoreCase("Success")) {
                    JSONArray result = object.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        List<OptionsItem> optionsItems = new ArrayList<>();
                        JSONArray options = result.getJSONObject(i).getJSONArray("options");
                        for (int j = 0; j < options.length(); j++) {
                            optionsItems.add(new OptionsItem(options.getJSONObject(j).getString("price"), options.getJSONObject(j).getString("label")));
                        }
                        productOptions.add(new ProductOptionItem(result.getJSONObject(i).getInt("category_id"), optionsItems, result.getJSONObject(i).getString("type"), result.getJSONObject(i).getString("title"), result.getJSONObject(i).getString("required")));
                    }
                    productAdapter = new ProductAdapter(productOptions);
                    binding.rvProduct.setAdapter(productAdapter);
                    binding.btnApply.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this, object.getString("code") + " : " + object.getString("message"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                Log.e("TAG", "getProducts: ", e);

            }
        }, error -> {
            binding.progressCircular.hide();
            Log.e("TAG", "getProducts: ", error);
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjlhNDQwZTgxMjBhMjM3NDMxZmQ0YTI4ZDJmZGE2MmI2MTlhNjcyNjIxZjQyNGU4NGMwOWFiZTcxMTgzM2ZhZjQ0NjA1Mjk3OTUzNTAyOGRkIn0.eyJhdWQiOiIxIiwianRpIjoiOWE0NDBlODEyMGEyMzc0MzFmZDRhMjhkMmZkYTYyYjYxOWE2NzI2MjFmNDI0ZTg0YzA5YWJlNzExODMzZmFmNDQ2MDUyOTc5NTM1MDI4ZGQiLCJpYXQiOjE2MjA3MzgyNjgsIm5iZiI6MTYyMDczODI2OCwiZXhwIjoxNjUyMjc0MjY4LCJzdWIiOiI0Iiwic2NvcGVzIjpbXX0.blym4pzYdXfFIqs5e0lWwmAQM2m5FKY9eqyxm2GE7pXzw6IONTL8C7COe1Nim7IFNV2OcBf7g4P8XcfNXFtOk_7pxmAZ0vgPKEFY2zMcNwLUAdyZoR553mud0KTS7a9gOQdZZoh6QhxoEbfE_APmjV7VYYw_R-mXKthKrj7XOfMjs7KLYOoqqut_MyALM6SVZ0Yj2PKuFTA2cdB11HkLrFIZyMjK8HXPrcNoesCL5Rs1EAKEbIQh6jXgYQUGB9q2fKwnXI9h5zotYeuK9djQ6_RFiR2bMfjSOGRJThbgTnfH0svQCj0gHFONOvq3wKbTw5CPERWWa4Vv0tqAyA45yBt5T-fsf6NmrWskMGhuKffMIDe1CeZbxnfl436UhVKXcmLOp7zCvz3fRDiKrwjh6wJPsu6mhr8t48fUc2AuN5QpBSohWEcI8p64CP5PTsCNHduLLk4Dt2fo_XNIkAZrze8x5JPM1B_4HR0S3ZRIhooH-l4sEIbJncajFOMigZEa8p4IFYtwkESWythagpdYGNSCnw60W5_Chto0ba-FBb9EbT1lmWyqIoh-XgP-WyaZ2UaUUmewbJrobBd_KnmzLixCr2ig9AbntmxQRwRKVxep0x-mYzoaHU4ExlWJ_8HwaV10XIp1ZjG9ncktx_tYH_vbVFSCgvbV7omMIMSXl4w");
                return header;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(60000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}