package cl.vicentepc.stressless.data;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.stressless.models.Pending;

public class Queries {

    public List<Pending> pendings () {

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }

        return pendings;

    }

}
