package view.analysis;

import java.io.File;
import java.io.IOException;

public interface ChartImg {

	File profitChartImg() throws IOException;

	File fairChartImg() throws IOException;

	File ticketChartImg() throws IOException;

}