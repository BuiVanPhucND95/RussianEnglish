package com.freelancer.buivanphuc.russianenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.freelancer.buivanphuc.russianenglish.activity.DetailKeyWordActivity;
import com.freelancer.buivanphuc.russianenglish.dto.FavoretisDTO;
import com.freelancer.buivanphuc.russianenglish.interfaces.IUpdateHisttory;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.List;

public class FavoretisAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<FavoretisDTO> favoretisDTOList;
    ViewHolderFavoretis viewHolderFavoretis;

    IUpdateHisttory iUpdateHisttory;
    public FavoretisAdapter(Context context, int layout, List<FavoretisDTO> favoretisDTOList,IUpdateHisttory iUpdateHisttory) {
        this.context = context;
        this.layout = layout;
        this.favoretisDTOList = favoretisDTOList;

        this.iUpdateHisttory = iUpdateHisttory;
    }
    @Override
    public int getCount() {
        return favoretisDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return  favoretisDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return favoretisDTOList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, parent, false);
            viewHolderFavoretis = new ViewHolderFavoretis();
            viewHolderFavoretis.imgDelete = view.findViewById(R.id.imgDelete);
            viewHolderFavoretis.txtword = view.findViewById(R.id.txtword);

            view.setTag(viewHolderFavoretis);
        } else {
            viewHolderFavoretis = (ViewHolderFavoretis) view.getTag();
        }

        FavoretisDTO favoretisDTO = favoretisDTOList.get(position);
        viewHolderFavoretis.txtword.setText(favoretisDTO.getWord());
        final String word = favoretisDTO.getWord();
        final String definition = favoretisDTO.getDefinition();
        final int ID = favoretisDTO.getId();

        viewHolderFavoretis.txtword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailKeyWordActivity.class);
                intent.putExtra("key",word);
                intent.putExtra("definition",definition);
                intent.putExtra("ID",ID);
                context.startActivity(intent);
            }
        });
        viewHolderFavoretis.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iUpdateHisttory.updateListView(ID);
            }
        });
        return view;
    }
    public class ViewHolderFavoretis {
        ImageView imgDelete;
        TextView txtword;
    }
}
