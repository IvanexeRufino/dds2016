package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.Mailer;

import java.util.List;

public class RepositoryProfiling extends RepositoryWithActions {
    private long maxTimeBeforeNotify = 1000000000;
    private String adminEmail = "some@email.com";

    public RepositoryProfiling(Repository repository) {
        super(repository);
    }

    public long getMaxTimeBeforeNotify() {

        return maxTimeBeforeNotify;
    }

    public void setMaxTimeBeforeNotify(long maxTimeBeforeNotify) {
        this.maxTimeBeforeNotify = maxTimeBeforeNotify;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public List<PointOfInterest> find(String criteria) {
        long startTime = System.nanoTime();
        List<PointOfInterest> result = repository.find(criteria);
        long estimatedTime = System.nanoTime() - startTime;

        notifyAdmin(estimatedTime);

        return result;
    }

    private void notifyAdmin(long time) {
        if (time > maxTimeBeforeNotify) {
            String subject = "Pois Manager: Búsqueda lenta";
            String content = "Tiempo que demoró la búsqueda: " + time + "\nTiempo máximo configurado: " + maxTimeBeforeNotify;

            try {
                Mailer.send(adminEmail, subject, content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
