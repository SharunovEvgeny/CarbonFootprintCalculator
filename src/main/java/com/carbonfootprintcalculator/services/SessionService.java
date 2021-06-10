package com.carbonfootprintcalculator.services;

import com.carbonfootprintcalculator.entities.Session;
import com.carbonfootprintcalculator.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {
  @Autowired SessionRepository sessionRepository;

  public void initSession() {
    Session session = new Session();
    sessionRepository.save(session);
  }

  public Optional<Session> getSession() {
    return sessionRepository.findFirstByOrderByIdDesc();
  }

  public void addSessionElectricityEmissionsCo2(int co2ElectricityEmissions) {
    Optional<Session> session = sessionRepository.findFirstByOrderByIdDesc();
    session.ifPresent(
        value -> {
          value.setElectricityEmissionsCo2(co2ElectricityEmissions);
          sessionRepository.save(value);
        });
  }

  public void addSessionCarEmissionsCo2(int co2CarEmissions) {
    Optional<Session> session = sessionRepository.findFirstByOrderByIdDesc();
    session.ifPresent(
        value -> {
          value.setCarEmissionsCo2(co2CarEmissions);
          sessionRepository.save(value);
        });
  }

  public void addSessionGasEmissionsCo2(int co2GasEmissions) {
    Optional<Session> session = sessionRepository.findFirstByOrderByIdDesc();
    session.ifPresent(
        value -> {
          value.setGasEmissionsCo2(co2GasEmissions);
          sessionRepository.save(value);
        });
  }

  public void addSessionFoodEmissionsCo2(int co2FoodEmissions) {
    Optional<Session> session = sessionRepository.findFirstByOrderByIdDesc();
    session.ifPresent(
        value -> {
          value.setFoodEmissionsCo2(co2FoodEmissions);
          sessionRepository.save(value);
        });
  }

  public void addSessionLifeEmissionsCo2(int co2LifeEmissions) {
    Optional<Session> session = sessionRepository.findFirstByOrderByIdDesc();
    session.ifPresent(
        value -> {
          value.setLifeEmissionsCo2(co2LifeEmissions);
          sessionRepository.save(value);
        });
  }

  public int getAllCo2() {
    Optional<Session> session = sessionRepository.findFirstByOrderByIdDesc();
    if (session.isPresent()) {
      session.get().calculateEmissions();
      sessionRepository.save(session.get());
      return session.get().getAllCo2Emissions();
    }
    return 0;
  }
}
