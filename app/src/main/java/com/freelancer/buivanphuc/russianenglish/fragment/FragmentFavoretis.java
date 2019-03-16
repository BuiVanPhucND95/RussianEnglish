package com.freelancer.buivanphuc.russianenglish.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.freelancer.buivanphuc.russianenglish.adapter.FavoretisAdapter;
import com.freelancer.buivanphuc.russianenglish.dao.FavoretisDAO;
import com.freelancer.buivanphuc.russianenglish.dto.FavoretisDTO;
import com.freelancer.buivanphuc.russianenglish.interfaces.IUpdateHisttory;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.List;

public class FragmentFavoretis extends Fragment implements IUpdateHisttory {
    ListView lvFavoretis;
    FavoretisDAO favoretisDAO;
    FavoretisAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_favoretis, container, false);
        lvFavoretis = view.findViewById(R.id.lvFavoretis);
        favoretisDAO = new FavoretisDAO(getContext());
        List<FavoretisDTO> favoretisDTOList= favoretisDAO.listFavo();
        adapter = new FavoretisAdapter(getContext(),R.layout.item_favoretis,favoretisDTOList,this);
        lvFavoretis.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void updateListView(int id) {
        favoretisDAO.DeleteFavo(id);
        List<FavoretisDTO> favoretisDTOList= favoretisDAO.listFavo();
        adapter = new FavoretisAdapter(getContext(),R.layout.item_favoretis,favoretisDTOList,this);
        lvFavoretis.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
