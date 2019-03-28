package com.freelancer.buivanphuc.russianenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.activity.DetailKeyWordActivity;
import com.freelancer.buivanphuc.russianenglish.dao.FavoretisDAO;
import com.freelancer.buivanphuc.russianenglish.dto.FavoretisDTO;
import com.freelancer.buivanphuc.russianenglish.dto.WordsDTO;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolderSearch> {
    Context context;
    int layout;
    List<WordsDTO> wordsDTOList;
    FavoretisDAO favoretisDAO;
    private boolean checkBackground = false;
    public SearchAdapter(Context context, int layout, List<WordsDTO> wordsDTOList) {
        this.context = context;
        this.layout = layout;
        this.wordsDTOList = wordsDTOList;
        favoretisDAO = new FavoretisDAO(context);
    }

    public class ViewHolderSearch extends RecyclerView.ViewHolder {
        ImageView imgFavorites;
        TextView txtKey;

        public ViewHolderSearch(@NonNull View itemView) {
            super(itemView);
            imgFavorites = itemView.findViewById(R.id.imgFavories);
            txtKey = itemView.findViewById(R.id.txtKey);
        }


    }

    @NonNull
    @Override
    public ViewHolderSearch onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, viewGroup, false);
        ViewHolderSearch viewHolder = new ViewHolderSearch(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderSearch viewHolder, final int i) {
        final WordsDTO wordsDTO = wordsDTOList.get(i);

        final int id = wordsDTO.getId();
        final String word = wordsDTO.getWord();
        final String definition = wordsDTO.getDefinition();

        viewHolder.txtKey.setText(wordsDTO.getWord());

        viewHolder.txtKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailKeyWordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("key", word);
                intent.putExtra("definition", definition);
                intent.putExtra("ID", id);
                context.startActivity(intent);
            }
        });

        viewHolder.imgFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBackground)
                {
                    FavoretisDTO favoretisDTO = new FavoretisDTO(wordsDTO.getId(), wordsDTO.getWord(), wordsDTO.getDefinition(),"true");
                    boolean check = favoretisDAO.addFavoretis(favoretisDTO);
                    if (check) {
                        viewHolder.imgFavorites.setImageResource(R.drawable.ic_favorited);
                    } else {
                        Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
                    }
                    checkBackground = !checkBackground;
                }else {
                    viewHolder.imgFavorites.setImageResource(R.drawable.ic_not_favorite);
                    favoretisDAO.DeleteFavo(id);
                    checkBackground = !checkBackground;
                }


            }

        });
    }

    @Override
    public int getItemCount() {
        return wordsDTOList.size();
    }

}
