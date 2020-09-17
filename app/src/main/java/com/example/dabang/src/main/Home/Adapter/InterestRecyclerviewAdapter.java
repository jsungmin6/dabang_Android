package com.example.dabang.src.main.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.dabang.R;
import com.example.dabang.src.main.Home.models.HomeInterestRegionItem;

import java.time.Instant;
import java.util.ArrayList;

import com.bumptech.glide.Glide;

public class InterestRecyclerviewAdapter extends RecyclerView.Adapter<InterestRecyclerviewAdapter.ViewHolder> {

    private ArrayList<HomeInterestRegionItem> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public InterestRecyclerviewAdapter(Context context, ArrayList<HomeInterestRegionItem> itemList, View.OnClickListener onClickItem) {
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.myinterest_item, parent, false);

        return new ViewHolder(view);
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//
//        holder = new InterestRecyclerviewAdapter(context,itemList,onClickItem).ViewHolder();
//        holder.regionName = (TextView) convertView.findViewById(R.id.home_interestDong);
//        holder.completionDate = (TextView) convertView.findViewById(R.id.completionDate);
//        holder.complexAddress = (TextView) convertView.findViewById(R.id.complexAddress);
//        holder.complexImg = (ImageView) convertView.findViewById(R.id.complexImg);
        
        HomeInterestRegionItem homeInterestRegionItem = itemList.get(position);
        
        holder.home_interestDong.setText(homeInterestRegionItem.getRegionName());
        
        holder.home_interestRoomNum.setText(homeInterestRegionItem.getRoomNum());
        
        holder.home_interestRoomType.setText(homeInterestRegionItem.getRoomType());

        //System.out.println(complexInfo.getComplexName());
        Glide
                .with(context)
                .load(homeInterestRegionItem.getRegionImg())
                .apply(new RequestOptions().override(400,800))
                //.apply(new RequestOptions().circleCrop().override(100,200))
                .into(holder.home_interestImg);

        //String item = itemList.get(position);
//
//        holder.textview.setText(item);
//        holder.textview.setTag(item);
//        holder.textview.setOnClickListener(onClickItem);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView home_interestImg;
        public TextView home_interestRoomNum;
        public TextView home_interestDong;
        public TextView home_interestRoomType;


        public ViewHolder(View itemView) {
            super(itemView);

            home_interestImg = itemView.findViewById(R.id.myInterestImg);
            home_interestRoomNum = itemView.findViewById(R.id.myInterestHomeNum);
            home_interestDong = itemView.findViewById(R.id.myInterestTitle);
            home_interestRoomType = itemView.findViewById(R.id.myInterestSubTitle);
        }
    }
}








//public class MyInterestRecyclerAdapter extends RecyclerView.Adapter<MyInterestRecyclerAdapter.ViewHolder> {
//
//    private ArrayList<HomeInterestRegionItem> mData = null ;
//
//    // 생성자에서 데이터 리스트 객체를 전달받음.
//    public MyInterestRecyclerAdapter(ArrayList<HomeInterestRegionItem> list) {
//        mData = list ;
//    }
//
//    // 아이템 뷰를 저장하는 뷰홀더 클래스.
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView region ;
//        TextView homeNum ;
//        TextView title ;
//        TextView subTitle ;
//
//        ViewHolder(View itemView) {
//            super(itemView) ;
//
//            // 뷰 객체에 대한 참조. (hold strong reference)
//            region = itemView.findViewById(R.id.myInterestImg);
//            homeNum = itemView.findViewById(R.id.myInterestHomeNum);
//            title = itemView.findViewById(R.id.myInterestTitle);
//            subTitle = itemView.findViewById(R.id.myInterestSubTitle);
//
//        }
//    }
//
//    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
//    @NonNull
//    @Override
//    public MyInterestRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //context 객체 만듬
//        Context context = parent.getContext() ;
//        //context 객체 이용해서 inflater 객체 만듬
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
//        //inflater객체 이용해서 레이아웃 인플레이트 시킴
//        View view = inflater.inflate(R.layout.myinterest_item, parent, false) ;
//        //??
//        MyInterestRecyclerAdapter.ViewHolder vh = new MyInterestRecyclerAdapter.ViewHolder(view) ;
//
//        return vh ;
//    }
//
//    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
//    @Override
//    public void onBindViewHolder(@NonNull MyInterestRecyclerAdapter.ViewHolder holder, int position) {
//
//        HomeInterestRegionItem item = mData.get(position) ;
//
//        holder.region.setImageResource(item.getRegionImg()); ;
//        holder.homeNum.setText(item.getHomeNum()) ;
//        holder.title.setText(item.getTitle()) ;
//        holder.subTitle.setText(item.getSubTitle()) ;
//
//    }
//
//    // getItemCount() - 전체 데이터 갯수 리턴.
//    @Override
//    public int getItemCount() {
//        return mData.size() ;
//    }
//}
