package com.example.dabang.src.main.Home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dabang.R;
import com.example.dabang.src.main.Home.Adapter.InterestRecyclerviewAdapter;
import com.example.dabang.src.main.Home.Adapter.PostRecyclerAdapter;
import com.example.dabang.src.main.Home.Adapter.PostRecyclerItem;
import com.example.dabang.src.main.Home.Adapter.SellInfoRecyclerAdapter;
import com.example.dabang.src.main.Home.Adapter.SellInfoRecyclerItem;
import com.example.dabang.src.main.Home.interfaces.HomeFragView;
import com.example.dabang.src.main.Home.models.HomeInterestRegionItem;
import com.example.dabang.src.main.Home.models.HomeInterestRegionResponse;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class HomeFragment extends Fragment implements HomeFragView {



    //나의 관심목록 사용할 인스턴스 생성
    RecyclerView mRecyclerView = null ;
    InterestRecyclerviewAdapter mAdapter = null ;
    ArrayList<HomeInterestRegionItem> mList = new ArrayList<HomeInterestRegionItem>();

//    //나의 관심단지 사용할 인스턴스 생성
//    RecyclerView recyclerView = null;
//    MyInterestRecyclerAdapter adapter = null;
//    ArrayList<MyInterestRecyclerItem> list = new ArrayList<MyInterestRecyclerItem>();

    //나의 관심단지 사용할 인스턴스 생성
    RecyclerView recyclerView2 = null;
    SellInfoRecyclerAdapter sellInfoAdapter = null;
    ArrayList<SellInfoRecyclerItem> SellInfoItemList = new ArrayList<SellInfoRecyclerItem>();

    //추천 콘텐츠 인스턴스 생성
    PostRecyclerAdapter postRecyclerAdapter = null;
    ArrayList<PostRecyclerItem> postRecyclerItemArrayList = new ArrayList<PostRecyclerItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //나의 관심 목록

        //fragment 인플레이트 해서 rootView 객체 만듬
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        //fregment1.xml에서 리싸이클러 뷰 찾아서 mRecyclerView에 저장
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.myinterestRecycler) ;

        // 리사이클러뷰에 MyInterestRecyclerAdapter 객체 지정.
        mAdapter = new InterestRecyclerviewAdapter(getActivity(), mList, onClickItem) ;
        mRecyclerView.setAdapter(mAdapter) ;

        // 리사이클러뷰에 LinearLayoutManager 지정. (HORIZONTAL)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)) ;

        // 아이템 추가.

        addInterestItem()


        mAdapter.notifyDataSetChanged() ;

        return rootView;

    }

    private View.OnClickListener onClickItem = new View.OnClickListener() { //item클릭시
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public void gethomeInterestResionSuccess(HomeInterestRegionResponse.HomeInterestRegionResponseResult[] result) {

    }

    @Override
    public void validateFailure(String message) {

    }


    public void addInterestItem(String regionName, String roomNum, String regionImg, String roomType) {

        HomeInterestRegionItem item = new HomeInterestRegionItem(regionName,roomNum,regionImg,roomType);

        item.setRegionImg(regionImg);
        item.setRoomNum(roomNum);
        item.setRoomType(roomType);
        item.setRegionName(regionName);

        mList.add(item);
    }


}

