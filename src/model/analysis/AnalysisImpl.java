package model.analysis;

import controller.EnvironmentControllerImpl;
import java.util.LinkedList;
import java.util.List;

public class AnalysisImpl implements Analysis {

  private final EnvironmentControllerImpl controller;
  private final List<String> fair = new LinkedList<>();
  private final List<String> profit = new LinkedList<>();
  private final List<String> tickets = new LinkedList<>();

  public AnalysisImpl(final EnvironmentControllerImpl controller) {
      this.controller = controller;
  }

  @Override
  public final List<String> fairLiking() {
      this.controller.getFairList().forEach(f -> {
          this.fair.add(f.getActivityType() + ": " + f.getName()
                 + ", Daily Visitors: " + f.getTotPeople() + "\n"); });
      return this.fair;
  }

  @Override
  public final List<String> profit() {
      this.controller.getProfitList().forEach(p -> {
          this.profit.add(p.getActivityType() + ": " + p.getName()
                 + ", Daily Income: " + p.getProfit() + "\n"); });
      return this.profit;
  }

  @Override
  public final List<String> tickets() {
      this.tickets.add("Total number of tickets sold: "
              + this.controller.getEntranceProfit().get(3) + "\n");
      this.tickets.add("Adult tickets income: "
              + this.controller.getEntranceProfit().get(0) + "\n");
      this.tickets.add("Reduced tickets income: "
              + this.controller.getEntranceProfit().get(1) + "\n");
      this.tickets.add("Season pass income: "
              + this.controller.getEntranceProfit().get(2) + "\n");
      return this.tickets;
  }

  @Override
  public final List<String> getTextualAnalysis() {
      final List<String> analysis = new LinkedList<>();
      analysis.addAll(this.tickets());
      analysis.addAll(this.fairLiking());
      analysis.addAll(this.profit());
      return analysis;
  }

  @Override
  public final String getAnalysisDescription() {
      return "\n***Here is a textual analysis carried out in the simulation, "
              + "which environment was set with the parameters you provided*** \n";
  }

}
