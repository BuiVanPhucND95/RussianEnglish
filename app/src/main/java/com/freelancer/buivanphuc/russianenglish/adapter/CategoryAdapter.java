package com.freelancer.buivanphuc.russianenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.activity.GrammarActivity;
import com.freelancer.buivanphuc.russianenglish.dto.CategoryDTO;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<CategoryDTO> categoryDTOList;
    ViewHolderCategory viewHolder;
    public CategoryAdapter(Context context, int layout, List<CategoryDTO>categoryDTOList){
        this.context =context;
        this.layout = layout;
        this.categoryDTOList = categoryDTOList;
    }
    @Override
    public int getCount() {
        return categoryDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, parent, false);
            viewHolder = new ViewHolderCategory();
            viewHolder.ln_category = view.findViewById(R.id.ln_category);
            viewHolder.txtName = view.findViewById(R.id.item_category);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderCategory) view.getTag();
        }
        final CategoryDTO categoryDTO = categoryDTOList.get(position);
        viewHolder.txtName.setText(categoryDTO.getName());
        viewHolder.ln_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GrammarActivity.class);
                intent.putExtra("link", categoryDTO.getLink());
                intent.putExtra("title",categoryDTO.getTitle());
                context.startActivity(intent);
            }
        });
        return view;
    }
    public class ViewHolderCategory{
        LinearLayout ln_category;
        TextView txtName;
    }
}
