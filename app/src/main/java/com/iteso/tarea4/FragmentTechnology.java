package com.iteso.tarea4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.tarea4.beans.ItemProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentTechnology() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView  = (RecyclerView)
                view.findViewById(R.id.fragment_technology_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        ArrayList<ItemProduct> myDataSet = new ArrayList<ItemProduct>();
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setTitle("MacBook Pro  17\"");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("33 123345678");
        itemProduct.setImage(0);
        itemProduct.setDescription(" Llevate esta Mac con un 30% de descuento para que puedas programar para XCode y Android sin tener que batallar tanto como en tu Windows" );


        ItemProduct itemProduct2 = new ItemProduct();
        itemProduct2.setTitle("Alienware");
        itemProduct2.setStore("BestBuy");
        itemProduct2.setLocation("Zapopan, Jalisco");
        itemProduct2.setPhone("33 123345678");
        itemProduct2.setImage(1);
        itemProduct2.setDescription(" Llevate esta Mac con un 30% de descuento para que puedas programar para XCode y Android sin tener que batallar tanto como en tu Mac" );


        if(this.getArguments() != null) {
            ItemProduct itemProductParce = new ItemProduct();
            itemProductParce = (ItemProduct) this.getArguments().getParcelable("ITEM");
            switch (itemProductParce.getImage()) {
                case 0:
                    itemProduct.setTitle(itemProductParce.getTitle());
                    itemProduct.setStore(itemProductParce.getStore());
                    itemProduct.setLocation(itemProductParce.getLocation());
                    itemProduct.setPhone(itemProductParce.getPhone());
                    break;
                case 1:
                    itemProduct2.setTitle(itemProductParce.getTitle());
                    itemProduct2.setStore(itemProductParce.getStore());
                    itemProduct2.setLocation(itemProductParce.getLocation());
                    itemProduct2.setPhone(itemProductParce.getPhone());
                    break;
            }
        }

        myDataSet.add(itemProduct2);
        myDataSet.add(itemProduct);

        mAdapter= new AdapterProducts(getActivity(),myDataSet);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

}
