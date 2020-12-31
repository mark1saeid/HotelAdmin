package com.troy.saferadmin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.makeramen.roundedimageview.RoundedImageView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.todkars.shimmer.ShimmerRecyclerView;


public class Orders extends Fragment {
   View view;


    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<ordermodel, Orders.NewsViewHolder> mPeopleRVAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, container, false);




        final ShimmerRecyclerView mShimmerRecyclerView = view.findViewById(R.id.shimmer_recycler_view);

        LinearLayoutManager layoutManager =  new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        mShimmerRecyclerView.setLayoutManager(layoutManager,
                R.layout.ordersitems);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("orders");
        mDatabase.keepSynced(true);
        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("orders");
        Query personsQuery = personsRef.orderByKey();

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<ordermodel>().setQuery(personsQuery, ordermodel.class).build();

        mPeopleRVAdapter = new FirebaseRecyclerAdapter<ordermodel, Orders.NewsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(Orders.NewsViewHolder holder, final int position, final ordermodel model) {
holder.setadults(model.getAdult());
holder.setchild(model.getChildren());
holder.setfood(model.getFood());
holder.setnights(model.getNights());
holder.setdetails(model.getDetails());
holder.settime(model.getTime());
holder.sethotelname(model.getHotelorder());
holder.setname(model.getName());
holder.setemail(model.getEmail());
holder.setphone(model.getPhone());


            }

            @Override
            public Orders.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.ordersitems, parent, false);

                return new Orders.NewsViewHolder(view);

            }
        };





        mShimmerRecyclerView.setAdapter(mPeopleRVAdapter);
        mShimmerRecyclerView.showShimmer();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ShimmerRecyclerView mShimmerRecyclerView = view.findViewById(R.id.shimmer_recycler_view);
                mShimmerRecyclerView.hideShimmer();
            }
        }, 2000);



        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.ref);
        pullToRefresh.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mShimmerRecyclerView.setAdapter(mPeopleRVAdapter);
                mShimmerRecyclerView.showShimmer();


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ShimmerRecyclerView mShimmerRecyclerView = view.findViewById(R.id.shimmer_recycler_view);
                        mShimmerRecyclerView.hideShimmer();
                        pullToRefresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        return view;
    }





    @Override
    public void onStart() {
        super.onStart();
        mPeopleRVAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();



    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public NewsViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }
        public void setname(String name){
            TextView textView = mView.findViewById(R.id.ordername);
            textView.setText(name);

        }
        public void setphone(String phone){
            TextView textView = mView.findViewById(R.id.orderphone);
            textView.setText(phone);
        }
        public void setemail(String email){
            TextView textView = mView.findViewById(R.id.orderemail);
            textView.setText(email);
        }
        public void settime(String time){
            TextView textView = mView.findViewById(R.id.ordertime);
            textView.setText(time);

        }
        public void sethotelname(String hotel){
            TextView textView = mView.findViewById(R.id.orderhotel);
            textView.setText(hotel);

        }
        public void setdetails(String details){
            TextView textView = mView.findViewById(R.id.orderdetails);
            textView.setText(details);

        }
        public void setfood(String food){
            TextView textView = mView.findViewById(R.id.ordername);
            textView.setText(food);
        }
        public void setnights(String nights){
            TextView textView = mView.findViewById(R.id.ordernights);
            textView.setText(nights);
        }
        public void setadults(String adults){
            TextView textView = mView.findViewById(R.id.orderadult);
            textView.setText(adults);
        }
        public void setchild(String child){
            TextView textView = mView.findViewById(R.id.orderchildren);
            textView.setText(child);
        }



    }





}
