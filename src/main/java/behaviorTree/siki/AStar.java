package behaviorTree.siki;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AStar {
    public int mapWith = 15;
    public int mapHeight = 15;

    public Point[][] map = new Point[mapWith][mapHeight];

    public void showLoad() {
        for (int j = map.length - 1; j >= 0; j--) {
            for (int i = 0; i < map[j].length; i++) {
                if (map[i][j].isLoad()) {
                    System.out.print("$");
                } else if (map[i][j].isWall()) {
                    System.out.print(1);
                } else if (map[i][j].getParent() != null) {
                    System.out.print(3);
                } else {
                    System.out.print(0);
                }
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public void showPath(Point start, Point end) {
        end.setLoad(true);
        System.out.println(end.getX() + "," + end.getY());
        if (start.equals(end) || end.getParent() == null) {
            return;
        } else {
            showPath(start, end.getParent());
        }
    }

    public void initMap() {
        for (int x = 0; x < mapWith; x++) {
            for (int y = 0; y < mapHeight; y++) {
                map[x][y] = new Point(x, y);
            }
        }
//    map[6][3].setWall(true);
        map[6][4].setWall(true);
        map[6][5].setWall(true);
        map[6][6].setWall(true);
        //    map[4][5].setWall(true);
        //    map[4][6].setWall(true);
    }

    public void findPath(Point start, Point end) {

        MyBinaryHeap<Point> openList = new MyBinaryHeap<Point>();
        List<Point> closeList = new ArrayList<Point>();
        openList.add(start);
        while (openList.size() > 0) {
//      Point point = findMinFOfPoint(openList);
            Point point = openList.findMin();
            openList.deleteMin();
            closeList.add(point);
            List<Point> surroundPoints = getSurroundPoints(point);
            pointsFilter(surroundPoints, closeList);

            System.out.println(point);

            if (point.getX() == 5 && point.getY() == 3) {
                int i = 0;
            }
            if (point.getX() == 5 && point.getY() == 5) {
                int i = 0;
            }
            for (Point surroundPoint : surroundPoints) {
                if (openList.indexOf(surroundPoint) > -1) {
                    float nowG = calcG(surroundPoint, point);
                    if (nowG < surroundPoint.getG()) {
                        surroundPoint.UpdateParent(point, nowG);
                    }
                } else {
                    surroundPoint.setParent(point);
                    calcF(surroundPoint, end);
                    openList.add(surroundPoint);
                }
            }
            //判断一下
            if (openList.indexOf(end) > -1) {
                break;
            }
        }
    }

    /**
     * 过滤掉周围的点
     *
     * @param src
     * @param closeList
     */
    public void pointsFilter(List<Point> src, List<Point> closeList) {
        for (Point p : closeList) {
            if (src.indexOf(p) > -1) {
                src.remove(p);
            }
        }
    }

    /**
     * 周围的点
     *
     * @param point
     * @return
     */
    public List<Point> getSurroundPoints(Point point) {
        Point up = null, down = null, left = null, right = null;
        Point lu = null, ru = null, ld = null, rd = null;
        if (point.getY() < mapHeight - 1) {
            up = map[point.getX()][point.getY() + 1];
        }
        if (point.getY() > 0) {
            down = map[point.getX()][point.getY() - 1];
        }
        if (point.getX() > 0) {
            left = map[point.getX() - 1][point.getY()];
        }
        if (point.getX() < mapWith - 1) {
            right = map[point.getX() + 1][point.getY()];
        }
        if (up != null && left != null) {
            lu = map[point.getX() - 1][point.getY() + 1];
        }
        if (up != null && right != null) {
            ru = map[point.getX() + 1][point.getY() + 1];
        }
        if (down != null && left != null) {
            ld = map[point.getX() - 1][point.getY() - 1];
        }
        if (down != null && right != null) {
            rd = map[point.getX() + 1][point.getY() - 1];
        }
        List<Point> list = new ArrayList<Point>();
        if (down != null && down.isWall() == false) {
            list.add(down);
        }
        if (up != null && up.isWall() == false) {
            list.add(up);
        }
        if (left != null && left.isWall() == false) {
            list.add(left);
        }
        if (right != null && right.isWall() == false) {
            list.add(right);
        }
        if (lu != null && lu.isWall() == false && left.isWall() == false && up.isWall() == false) {
            list.add(lu);
        }
        if (ld != null && ld.isWall() == false && left.isWall() == false && down.isWall() == false) {
            list.add(ld);
        }
        if (ru != null && ru.isWall() == false && right.isWall() == false && up.isWall() == false) {
            list.add(ru);
        }
        if (rd != null && rd.isWall() == false && right.isWall() == false && down.isWall() == false) {
            list.add(rd);
        }
        return list;
    }

    /**
     * 开启列表中F值最小的点
     *
     * @param openList
     * @return
     */
    public Point findMinFOfPoint(List<Point> openList) {
        float f = Float.MAX_VALUE;
        Point temp = null;
        for (Point p : openList) {
            if (p.getF() < f) {
                temp = p;
                f = p.getF();
            }
        }
        return temp;
    }

    /*************************************************************
     *第一步，写出计算FGH的值
     **********************************************************/
    /**
     * 计算F值
     *
     * @param now 当前点
     * @param end 终点
     */
    public void calcF(Point now, Point end) {
        //F = G + H
        // H 表示从指定的方格移动到终点 B 的预计耗费 (H 有很多计算方法, 这里我们设定只可以
        //上下左右移动).
        //G 表示从起点 A 移动到网格上指定方格的移动耗费 (可沿斜方向移动).
        float h = calcH(now, end);
        float g = calcG(now, now.getParent());
        float f = g + h;
        now.updateFGH(f, g, h);

    }

    /**
     * 获取H值
     * H 表示从指定的方格移动到终点 B 的预计耗费
     * (H 有很多计算方法, 这里我们设定只可以上下左右移动).
     *
     * @param start
     * @param end
     * @return
     */
    public float calcH(@NotNull Point start, @NotNull Point end) {
        return Math.abs(end.getX() - start.getX()) + Math.abs(end.getY() - start.getY());
    }

    /**
     * 获取G值
     * G 表示从起点 A 移动到网格上指定方格的移动耗费 (可沿斜方向移动).
     * 父节点到走到该节点的消耗
     *
     * @param start
     * @param parent
     * @return
     */
    public float calcG(@NotNull Point start, @NotNull Point parent) {
        float g = 0;
        if (start.getParent() == null) {
            g = 0;
        } else {
            g = PointUtil.getDistance(start, parent) + parent.getG();
        }
        return g;
    }

}
