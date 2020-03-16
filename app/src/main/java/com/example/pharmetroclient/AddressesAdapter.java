package com.example.pharmetroclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.pharmetroclient.DeliveryActivity.SELECT_ADDRESS;
import static com.example.pharmetroclient.MyAccountFragment.MANAGE_ADDRESS;
import static com.example.pharmetroclient.MyAddressesActivity.refreshItem;


public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.Viewholder> {

    private List<AddressesModel> addressesModelList;
    private int MODE;
    private int preSelectedposition;

    public AddressesAdapter(List<AddressesModel> addressesModelList , int MODE) {
        this.addressesModelList = addressesModelList;
        this.MODE = MODE;
    }

    @NonNull
    @Override
    public AddressesAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adresses_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.Viewholder viewholder, int position) {
        String name = addressesModelList.get(position).getFullname();
        String address = addressesModelList.get(position).getAddress();
        String pincode = addressesModelList.get(position).getPincode();
        Boolean selected = addressesModelList.get(position).getSelected();
        viewholder.setData(name,address,pincode,selected,position);

    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView fullname;
        private TextView address;
        private TextView pincode;
        private ImageView icon;

        public Viewholder(View itemView){
            super(itemView);

            fullname = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            pincode = itemView.findViewById(R.id.pincode);
            icon = itemView.findViewById(R.id.icon_view);

        }

        private void setData(String userName, String userAddress, String userPincode, final Boolean selected, final int position){
            fullname.setText(userName);
            address.setText(userAddress);
            pincode.setText(userPincode);

            if(MODE == SELECT_ADDRESS){

                icon.setImageResource(R.drawable.checkbox);
                if (selected){
                    icon.setVisibility(View.VISIBLE);
                    preSelectedposition = position;
                }else{
                    icon.setVisibility(View.GONE);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(preSelectedposition != position) {
                            addressesModelList.get(position).setSelected(true);
                            addressesModelList.get(preSelectedposition).setSelected(false);
                            refreshItem(preSelectedposition, position);
                            preSelectedposition = position;
                        }
                    }
                });

            }else if(MODE == MANAGE_ADDRESS){

            }
        }
    }
}
