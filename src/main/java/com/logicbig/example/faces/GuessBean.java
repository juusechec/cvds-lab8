package com.logicbig.example.faces;

import com.logicbig.example.data.MyConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

@Component
@ManagedBean
@ViewScoped
public class GuessBean {
    @Autowired
    MyConfigurationService myConfigurationService;
    private int number;
    private int reward;
    private int tries;
    private String state;
    private ArrayList<Integer> alreadyTried;

    public GuessBean(){
        reset();
    }

    public void guess(int attempt){
        addTry();
        alreadyTried.add(attempt);
        System.out.println("Para ganar use el número: " + number);
        if (attempt == number){
            setState("Win: " + String.valueOf(reward));
        }else{
            setReward(reward - 10000);
            setState("You still do not win");
        }
    }

    public void onDatabaseLoaded() {
        Integer dbReward = Integer.parseInt(myConfigurationService.getValorOfPremio());
        System.out.println("Se consulta de la base de datos la recompensa: " + dbReward);
        setReward(dbReward);
    }

    public void reset(){
        int randomNumber = (int)(Math.random()*10 + 1);
        alreadyTried = new ArrayList<>();
        setTries(0);
        setNumber(randomNumber);
        setReward(100000);
        setState("You still do not win");
    }

    public int getNumber(){
        return number;
    }

    public int getReward(){
        return reward;
    }

    public int getTries(){
        return tries;
    }

    public String getState(){
        return state;
    }

    public void setNumber(int number){
        this.number =  number;

    }

    public void setTries(int tries){
        this.tries = tries;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setReward(int reward){
        this.reward = reward;
    }

    public void addTry(){
        int newTry = getTries() + 1;
        setTries(newTry);
    }

    public ArrayList<Integer> getAlreadyTried(){
        return alreadyTried;
    }
}
