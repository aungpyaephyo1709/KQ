package com.app.aungpyaephyo.ucs_patheinvoting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardsAdapter adapter;
    private List<Card> albumList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_recycler_view);
        recyclerView =  findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new CardsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        Bundle selection=getIntent().getExtras();
        if(selection!=null){
            String selected=selection.getString("data");
            if(selected.equals("boys")){
                setTitle("UCSP King Selections");
                prepareAlbumsBoys();
            }
            else {
                setTitle("UCSP Queen Selections");
                prepareAlbumsGirls();
            }

        }

    }
    private void prepareAlbumsGirls() {

        Card a = new Card(Global.g1.name, Global.g1.section, Global.g1.photo);
        albumList.add(a);

        a = new Card(Global.g2.name, Global.g2.section, Global.g2.photo);
        albumList.add(a);

        a = new Card(Global.g3.name, Global.g3.section, Global.g3.photo);
        albumList.add(a);

        a = new Card(Global.g4.name, Global.g4.section, Global.g4.photo);
        albumList.add(a);

        a = new Card(Global.g5.name, Global.g5.section, Global.g5.photo);
        albumList.add(a);

        a = new Card(Global.g6.name, Global.g6.section, Global.g6.photo);
        albumList.add(a);

        a = new Card(Global.g7.name, Global.g7.section, Global.g7.photo);
        albumList.add(a);

        a = new Card(Global.g8.name, Global.g8.section, Global.g8.photo);
        albumList.add(a);

        a = new Card(Global.g9.name, Global.g9.section, Global.g9.photo);
        albumList.add(a);

        a = new Card(Global.g10.name, Global.g10.section, Global.g10.photo);
        albumList.add(a);

        a = new Card(Global.g11.name, Global.g11.section, Global.g11.photo);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbumsBoys() {

        Card a = new Card(Global.b1.name, Global.b1.section, Global.b1.photo);
        albumList.add(a);

        a = new Card(Global.b2.name, Global.b2.section, Global.b2.photo);
        albumList.add(a);

        a = new Card(Global.b3.name, Global.b3.section, Global.b3.photo);
        albumList.add(a);

        a = new Card(Global.b4.name, Global.b4.section, Global.b4.photo);
        albumList.add(a);

        a = new Card(Global.b5.name, Global.b5.section, Global.b5.photo);
        albumList.add(a);

        a = new Card(Global.b6.name, Global.b6.section, Global.b6.photo);
        albumList.add(a);

        a = new Card(Global.b7.name, Global.b7.section, Global.b7.photo);
        albumList.add(a);

        a = new Card(Global.b8.name, Global.b8.section, Global.b8.photo);
        albumList.add(a);

        a = new Card(Global.b9.name, Global.b9.section, Global.b9.photo);
        albumList.add(a);

        a = new Card(Global.b10.name, Global.b10.section, Global.b10.photo);
        albumList.add(a);

        a = new Card(Global.b11.name, Global.b11.section, Global.b11.photo);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
