package util;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph {

  JFreeChart graph;
  XYSeriesCollection data = new XYSeriesCollection();
  String title;
  String xName;
  String yName;

  public Graph(String t, String x, String y) {
    this.title = t;
    this.xName = x;
    this.yName = y;
    this.graph = ChartFactory.createXYLineChart(title, x, y, data);
  }

  public void createGraph(String id, double[] x, double[] y) {
    XYSeries s = new XYSeries(id);
    int n = x.length;
    for (int i = 0; i < n; i++) {
      s.add(x[i], y[i]);
    }
    data.addSeries(s);
  }

  public void clear() {
    data.removeAllSeries();
  }

  public JPanel viewGraph() {
    return new ChartPanel(graph);
  }
}
