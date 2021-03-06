package com.example.tabproject;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// 파일에 데이터를 보여주기 위한 처리
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordListViewHolder> {

    private ArrayList<WordList> wlist;

    public WordListAdapter(ArrayList<WordList> wlist){
        this.wlist = wlist;
    }

    // 레이아웃 파일에 있는 UI 컴포넌트를 WordListViewHolder 클래스의 멤버 변수와 연결
    public class WordListViewHolder extends RecyclerView.ViewHolder{
        TextView wordlist;
        ImageView country;

        public WordListViewHolder(View view){
            super(view);
            wordlist = (TextView)view.findViewById(R.id.wordlist);
            country = (ImageView)view.findViewById(R.id.country);
        }

    }

    @NonNull
    @Override
    public WordListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wordlist_item,viewGroup,false);
        return new WordListAdapter.WordListViewHolder(view);
    }

    // onBindViewHolder가 호출될 때 WordListViewHolder에 데이터를 추가함함
   @Override
    public void onBindViewHolder(@NonNull WordListViewHolder viewholder, int position) {
        viewholder.wordlist.setText(wlist.get(position).getWordlist());
        if(wlist.get(position).getLan().equals("en")){
            viewholder.country.setImageResource(R.drawable.ic_en);
        }else if(wlist.get(position).getLan().equals("ja")){
            viewholder.country.setImageResource(R.drawable.ic_ja);
       }else{
            viewholder.country.setImageResource(R.drawable.ic_ch);
       }
    }

    @Override
    public int getItemCount() {
        return (null != wlist ? wlist.size() : 0);
    }
}
