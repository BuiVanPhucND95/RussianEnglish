package com.freelancer.buivanphuc.russianenglish.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.freelancer.buivanphuc.russianenglish.adapter.HistoryAdapter;
import com.freelancer.buivanphuc.russianenglish.dao.HistoryDAO;
import com.freelancer.buivanphuc.russianenglish.dto.HistoryDTO;
import com.freelancer.buivanphuc.russianenglish.interfaces.IUpdateHisttory;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.List;

public class HistotyFragment extends Fragment implements IUpdateHisttory {
    ListView lvHistory;
    HistoryDAO historyDAO;
    HistoryAdapter historyAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history, container, false);
        lvHistory = view.findViewById(R.id.lvHistory);
        historyDAO = new HistoryDAO(getContext());
        List<HistoryDTO> historyDTOList = historyDAO.listHistory();
        historyAdapter = new HistoryAdapter(getContext(), R.layout.item_history, historyDTOList,this);
        lvHistory.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void updateListView(int id) {
        historyDAO.DeleteHistory(id);
        List<HistoryDTO> historyDTOList = historyDAO.listHistory();
        historyAdapter = new HistoryAdapter(getContext(), R.layout.item_history, historyDTOList,this);
        lvHistory.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
    }

}
