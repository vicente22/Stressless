package cl.vicentepc.stressless.data;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.stressless.models.Pending;

public class Queries {

    public List<Pending> notDone() {

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;

    }

    public List<Pending> done() {

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 1");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;

    }

    public Pending byId(long idPending) {
        Pending pending;
        pending = Pending.findById(Pending.class, idPending);
        return pending;
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        List<Pending> pendings = notDone();

        for (int i = 0; i < pendings.size(); i++) {
            names.add(pendings.get(i).getName());
        }

        return names;
    }

}
