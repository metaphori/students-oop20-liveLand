package model.analysis.save;

import java.io.File;
import java.io.IOException;

public interface ChartImg {

    /**
     * @return a file containing the Profit chart saved as jpeg
     * @throws IOException
     */
    File profitChartImg() throws IOException;

    /**
     * @return a file containing the Fair chart saved as jpeg
     * @throws IOException
     */
    File fairChartImg() throws IOException;

}
