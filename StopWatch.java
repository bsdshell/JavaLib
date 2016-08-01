package classfile;

public class StopWatch {
  private long startTime = 0;
  private long stopTime = 0;
  private boolean running = false;

  public void start() {
    this.startTime = System.currentTimeMillis();
    this.running = true;
  }

  public void stop() {
    this.stopTime = System.currentTimeMillis();
    this.running = false;
  }

  //elaspsed time in milliseconds
  public long getElapsedTime() {
    long elapsed;
    if (running) {
      elapsed = (System.currentTimeMillis() - startTime);
    }
    else {
      elapsed = (stopTime - startTime);
    }
    return elapsed;
  }

  public long printTime() {
    long elapsed;
    if (running) {
      elapsed = (System.currentTimeMillis() - startTime);
    }
    else {
      elapsed = (stopTime - startTime);
    }
    System.out.println("milliseconds=[" + elapsed + "]"); 
    return elapsed;
  }

  //elaspsed time in seconds
  public long getElapsedTimeSecs() {
    long elapsed;
    if (running) {
      elapsed = ((System.currentTimeMillis() - startTime) / 1000);
    }
    else {
      elapsed = ((stopTime - startTime) / 1000);
    }

    System.out.println("second=[" + elapsed + "]"); 

    return elapsed;
  }
}
