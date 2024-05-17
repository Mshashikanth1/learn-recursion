package DesignPatterns.BehavioralDesignPattern.java;




/*
*
*
Observer Pattern: This pattern defines a one-to-many relationship between objects where one object (subject)
maintains a list of dependent objects (observers) and notifies them automatically about any state changes.


*
*
*
* *
* */

import java.util.List;
import java.util.ArrayList;
public class ObserverBehavioralDesignPattern {
    interface Subject {
        void registerObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObservers();
    }

    interface Observer {
        void update(Subject subject);
    }

    class WeatherData implements Subject {
        private List<Observer> observers;
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherData() {
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {

        }


    }

}
