package ood;

import java.util.ArrayList;
import java.util.List;

public class restaurant{
    private static final number_small = 10;
    private static final number_medium = 10;
    private static final number_large = 10;
    private Map<String,table> occupiedtable;
    private List<table> small;
    private List<table> medium;
    private List<table> large;
    
    public restaurant(){
        small = new ArrayList<table>(number_small);
        medium = new ArrayList<table>(number_medium);
        LARGE = new ArrayList<table>(number_large);
        occupiedtable = new HashMap<String,table>;
    }
    
    private void creattable(){
        for(int i =1; i<= number_small;i++){
            small.add(new smalltable(i));
        }
        for(int i =1; i<= number_medium;i++){
            medium.add(new mediumtable(i));
        }
        for(int i =1; i<= number_large;i++){
            large.add(new largettable(i));
        }
    }
    
    public String allocate_table(customer cus){
        private tb;
        if(cus.num<=2){
            if(tb = getfirst(small) != null){
                map.put(cus.name, tb);
            }
            else if(tb = getfirst(medium) != null){
                map.put(cus.name, tb);
            }
            else if(tb = getfirst(large) != null){
                map.put(cus.name, tb);
            }
        }
        return cus.name;
    }
    
    public table getfirst(List<table> tb){
        Iterator tbiterator = tb.iterator();
        boolean isfound = false;
        table tbslot = null;
        while(tbiterator.hasNext()&& !isfound){
            tbslot = tbiterator.next();
            if(!tbslot.isOccupied){
                tbslot.tabled;
                isfound = true;
            }
        }
        return tbslot;
    }
    
    public void remove(String name){
        for(String t: this.occupiedtable.keySet()){
            if(t== name){
                this.occupiedtable.remove(t);
                break;
            }
        }
    }
    
    public int getcapacity(){
        int capacity = 0;
        for(String t: this.occupiedtable.keySet()){
            capacity+=occupiedtable.get(t).numsets;
        }
        return capacity;
    }
}

public abstract class table{
    private boolean isOccupied;
    private int id;
    private int numsets;
    public table(int id){
        this.id=id;
        isOccupied = false;
    }
    boolean isOccupied(){
        return isOccupied;
    }
    int gettablenumber(){
        return id;
    }
    void tabled(){
        isOccupied = true;
    }
    void untabled(){
        isOccupied = false;
    }
    int getnum(){
        return numsets;
    }
}

class smalltable extends table{
    private int smallsize = 2;
    public smalltable(int id, int numsets){
        super(id);
        super.numsets = smallsieze;
    }
}

class mediumtable extends table{
    private int mediumsize = 4;
    public smediumtable(int id){
        super(id);
    }
}

class largetable extends table{
    private int largesize = 10;
    public largetable(int id, int numsets){
        super(id);
        super.numsets = largesize;
    }
}

public class customer{
    private String name;
    private int num;
    public customer(int name, int num){
        this.name = name;
        this.num = num;
    }
}