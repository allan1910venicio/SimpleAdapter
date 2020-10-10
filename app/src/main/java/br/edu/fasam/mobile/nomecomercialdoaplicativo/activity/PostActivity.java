package br.edu.fasam.mobile.nomecomercialdoaplicativo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.fasam.mobile.nomecomercialdoaplicativo.R;
import br.edu.fasam.mobile.nomecomercialdoaplicativo.debug.DebugActivity;

public class PostActivity extends DebugActivity {

    EditText txtUserId, txtTitle, txtBody;
    ListView listViewPost;
    List<HashMap<String, String>> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void AddPost(View view) {

        txtUserId = findViewById(R.id.txtUserId);
        txtTitle = findViewById(R.id.txtTitle);
        txtBody = findViewById(R.id.txtBody);

        simpleAdapter(txtUserId.getText().toString(),txtTitle.getText().toString(), txtBody.getText().toString());
    }

    private void simpleAdapter(String userId, String titulo, String body) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("title", titulo);
        map.put("body", body);

        lista.add(map);

        String[] from = {"userId", "title", "body"};
        int[] to = {R.id.txtItemUserId, R.id.txtItemTitle, R.id.txtItemBody};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_post, from, to);

        listViewPost = findViewById(R.id.listViewPost);
        listViewPost.setAdapter(simpleAdapter);
    }
}
