package com.example.salledesport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class adapter_seance extends ArrayAdapter <Seance>
{
    public adapter_seance(Context context, List<Seance> objects)
    {
        super(context, 0 , objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_seance, parent, false);
        }

        TextView date = convertView.findViewById(R.id.item_date);
        TextView seance = convertView.findViewById(R.id.item_seance);
        TextView coach = convertView.findViewById(R.id.item_coach);

        Seance currentDemande = getItem(position);

        date.setText(currentDemande.getDateSeance());
        seance.setText(currentDemande.getNomActivite());
        coach.setText(currentDemande.getNomCoach());

        return convertView;
    }
}
