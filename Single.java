class Single {
  private static Single INSTANCE =new Single();
  private Single () {}
  public static Single get Instance() {
  return INSTANCE;
  }
}