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
import com.freelancer.buivanphuc.russianenglish.dto.HistoryDTO;
import com.freelancer.buivanphuc.russianenglish.interfaces.IUpdateHisttory;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<HistoryDTO> historyDTOS;
    ViewHolderHistory viewHolderHistory;

    IUpdateHisttory iUpdateHisttory;
    public HistoryAdapter(Context context, int layout, List<HistoryDTO> historyDTOS,IUpdateHisttory iUpdateHisttory) {
        this.context = context;
        this.layout = layout;
        this.historyDTOS = historyDTOS;

        this.iUpdateHisttory = iUpdateHisttory;
    }

    @Override
    public int getCount() {
        return historyDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return historyDTOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return historyDTOS.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, parent, false);
            viewHolderHistory = new ViewHolderHistory();
            viewHolderHistory.imgDelete = view.findViewById(R.id.imgDelete);
            viewHolderHistory.txtword = view.findViewById(R.id.txtword);

            view.setTag(viewHolderHistory);
        } else {
            viewHolderHistory = (ViewHolderHistory) view.getTag();
        }
        HistoryDTO historyDTO = historyDTOS.get(position);
        viewHolderHistory.txtword.setText(historyDTO.getWord());
        final String word = historyDTO.getWord();
        final String definition = historyDTO.getDefinition();
        final int ID = historyDTO.getId();

        viewHolderHistory.txtword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailKeyWordActivity.class);
                intent.putExtra("key",word);
                intent.putExtra("definition",definition);
                intent.putExtra("ID",ID);
                context.startActivity(intent);
            }
        });
        viewHolderHistory.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               iUpdateHisttory.updateListView(ID);
            }
        });
        return view;
    }
    public class ViewHolderHistory {
        ImageView imgDelete;
        TextView txtword;
    }
}
