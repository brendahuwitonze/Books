package com.moringaschool.books;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NoteAdapter extends FirebaseRecyclerAdapter<User, NoteAdapter.NoteHolder> {
    public NoteAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull User model) {
        holder.textViewTitle.setText(model.getName());

        holder.textViewPriority.setText(String.valueOf(model.getEmail()));
    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,
                parent, false);
        return new NoteHolder(v);
    }
    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getRef().removeValue();
    }
    class NoteHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;
        public NoteHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.fun);
            textViewPriority = itemView.findViewById(R.id.userrole);
        }
    }
}
