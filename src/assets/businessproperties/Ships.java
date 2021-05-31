package assets.businessproperties;

import java.io.Serializable;

public class Ships implements Serializable  {
    private String name;
    private String id;
    private String route;
    private static int freightCapacity = 20;
    private int totalFreights;
    private String assignedShippingPortName;

    public Ships(String name, String id, String route, String assignedShippingPortName) {
        this.name = name;
        this.id = id;
        this.route = route;
        this.assignedShippingPortName = assignedShippingPortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getFreightCapacity() {
        return freightCapacity;
    }

    public int getTotalFreights() {
        return totalFreights;
    }

    public void setTotalFreights(int totalFreights) {
        this.totalFreights = totalFreights;
    }

    public String updateTotalFreights() {
        if(this.totalFreights < freightCapacity) {
            this.totalFreights++;
            return "Freight added to ship";
        }
        return "Freight capacity reached.";
    }
    
    public void setAssignedShippingPortName(String assignedShippingPortName) {
        this.assignedShippingPortName = assignedShippingPortName;
    }

    public String getAssignedShippingPortName() {
        return assignedShippingPortName;
    }
    
    
}
