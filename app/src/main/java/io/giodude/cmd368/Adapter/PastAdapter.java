package io.giodude.cmd368.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.giodude.cmd368.Model.PastModel;
import io.giodude.cmd368.R;

public class PastAdapter extends RecyclerView.Adapter<PastAdapter.ViewHolder> {
    public Context context;
    public List<PastModel.PreviousEvents> data;
    public PastModel.PreviousEvents ee;
    TextView title1,hname,aname,hscore,ascore,leagues,season,date,sport;
    ImageView images;
    public PastAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.eventsitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(data.get(position));
        ee = data.get(position);
        holder.date.setText(ee.getDateEvent());
//        holder.time.setText(ee.getStrTime());
        holder.league.setText(ee.getStrLeague());
        holder.season.setText(ee.getStrSeason());
        holder.home.setText(ee.getStrHomeTeam());
        holder.away.setText(ee.getStrAwayTeam());
        holder.venue.setText(ee.getStrVenue());
        holder.homescore.setText(ee.getHomescore());
        holder.awayscore.setText(ee.getAwayscore());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.eventdetails);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title1 = myDialog.findViewById(R.id.eventtimer);
        hname = myDialog.findViewById(R.id.homer);
        aname = myDialog.findViewById(R.id.awayr);
        hscore = myDialog.findViewById(R.id.homescorer);
        ascore = myDialog.findViewById(R.id.awayscorer);
        leagues = myDialog.findViewById(R.id.eventleaguer);
        season = myDialog.findViewById(R.id.eventseasonr);
        date = myDialog.findViewById(R.id.eventdater);
        sport = myDialog.findViewById(R.id.eventvenuer);
        images = myDialog.findViewById(R.id.eventimg);
        for (int i = 0; i<data.size(); i++) {
            if(holder.home.getText()==data.get(position).getStrHomeTeam()){
                hname.setText(data.get(position).getStrHomeTeam());
                aname.setText(data.get(position).getStrAwayTeam());
                hscore.setText(data.get(position).getHomescore());
                ascore.setText(data.get(position).getAwayscore());
                date.setText(data.get(position).getDateEvent());
                title1.setText(data.get(position).getStrTime());
                season.setText(data.get(position).getStrSeason());
                leagues.setText(data.get(position).getStrLeague());
                Picasso.get().load(data.get(position).getStrThumb()).into(images);
                sport.setText(data.get(position).getStrVenue());
//                leagues.setText(ee.getLeague().getSlug());
//                season.setText(ee.getSeason().getName());
            }
        }
        holder.itemView.setOnClickListener(v -> myDialog.show());
//        Picasso.get().load(data.get(position).getStrThumb()).into(holder.eimg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView time;
        public TextView league;
        public TextView season;
        public TextView home;
        public TextView away;
        public TextView venue;
        public TextView homescore;
        public TextView awayscore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.eventdate);
            league = itemView.findViewById(R.id.eventleague);
            home = itemView.findViewById(R.id.home);
            awayscore = itemView.findViewById(R.id.awayscore);
            homescore = itemView.findViewById(R.id.homescore);
            away = itemView.findViewById(R.id.away);
            season = itemView.findViewById(R.id.eventseason);
            venue = itemView.findViewById(R.id.eventvenue);
        }
    }
}
