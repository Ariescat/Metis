package base.behaviorTree.siki;

public class Point implements Comparable<Point> {
    private Point parent;
    private int x;
    private int y;

    private float F;
    private float G;
    private float H;

    private boolean isWall = false;
    private boolean isLoad = false;

    public Point(int x, int y) {
        this(x, y, null);
    }

    public Point(int x, int y, Point parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public void UpdateParent(Point parent, float g) {
        this.parent = parent;
        this.G = g;
        F = G + H;
    }

    public void updateFGH(float f, float g, float h) {
        this.F = f;
        this.G = g;
        this.H = h;
    }

    public Point getParent() {
        return parent;
    }

    public void setParent(Point parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getF() {
        return F;
    }

    public void setF(float f) {
        F = f;
    }

    public float getG() {
        return G;
    }

    public void setG(float g) {
        G = g;
    }

    public float getH() {
        return H;
    }

    public void setH(float h) {
        H = h;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean wall) {
        isWall = wall;
    }

    public boolean isLoad() {
        return isLoad;
    }

    public void setLoad(boolean load) {
        isLoad = load;
    }

    @Override
    public int compareTo(Point point) {
        return Float.compare(F, point.getF());
    }

    @Override
    public String toString() {
        return "Point " + (getX() + 1) + "," + (getY() + 1);
    }
}
