package com.freelancer.buivanphuc.russianenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.freelancer.buivanphuc.russianenglish.activity.DetailKeyWordActivity;
import com.freelancer.buivanphuc.russianenglish.dao.FavoretisDAO;
import com.freelancer.buivanphuc.russianenglish.dao.WordsDAO;
import com.freelancer.buivanphuc.russianenglish.dto.FavoretisDTO;
import com.freelancer.buivanphuc.russianenglish.dto.WordsDTO;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.List;

public class SearchAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<WordsDTO> wordsDTOList;
    ViewHolderSearch viewHolderSearch;
    FavoretisDAO favoretisDAO;

    public SearchAdapter(Context context, int layout, List<WordsDTO> wordsDTOList) {
        this.context = context;
        this.layout = layout;
        this.wordsDTOList = wordsDTOList;
        favoretisDAO = new FavoretisDAO(context);
    }

    @Override
    public int getCount() {
        return wordsDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordsDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return wordsDTOList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, parent, false);
            viewHolderSearch = new ViewHolderSearch();
            viewHolderSearch.imgFavorites = view.findViewById(R.id.imgFavories);
            viewHolderSearch.txtKey = view.findViewById(R.id.txtKey);

            view.setTag(viewHolderSearch);
        } else {
            viewHolderSearch = (ViewHolderSearch) view.getTag();
        }
        final WordsDTO wordsDTO = wordsDTOList.get(position);
        final int id = wordsDTO.getId();
        final String word = wordsDTO.getWord();
        final String definition = wordsDTO.getDefinition();
        viewHolderSearch.txtKey.setText(wordsDTO.getWord());
        viewHolderSearch.txtKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailKeyWordActivity.class);
                intent.putExtra("key", word);
                intent.putExtra("definition", definition);
                intent.putExtra("ID", id);
                context.startActivity(intent);
            }
        });
        viewHolderSearch.imgFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoretisDTO favoretisDTO = new FavoretisDTO(wordsDTO.getId(), wordsDTO.getWord(), wordsDTO.getDefinition());
                boolean check = favoretisDAO.addFavoretis(favoretisDTO);
                if (check) {
                    favoretisDAO.updateStatus(wordsDTO.getId(), "true");
                    viewHolderSearch.imgFavorites.setImageResource(R.drawable.ic_favorited);

                } else {
                    Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
                }
            }
        });
        String status = favoretisDAO.getStatus(wordsDTO.getId());
        Log.d("status",status);
        if(status.equals("true"))
        {
            viewHolderSearch.imgFavorites.setImageResource(R.drawable.ic_favorited);
        }else{
            viewHolderSearch.imgFavorites.setImageResource(R.drawable.ic_not_favorite);
        }

        return view;
    }

    public class ViewHolderSearch {
        ImageView imgFavorites;
        TextView txtKey;
    }
}
