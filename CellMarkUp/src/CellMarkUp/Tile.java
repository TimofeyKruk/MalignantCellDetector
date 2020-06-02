package CellMarkUp;

public class Tile {
    private String imageName;
    private int y;
    private int x;
    private int sy;
    private int sx;
    private int level;
    private String tileName;

    private boolean hasCells;
    private double brownCells;
    private double blueCells;

    public Tile() {
    }

    public Tile(String csvString) {
        //image_name,y,x,sy,sx,level,tile_name
        try{
            String [] tokens=csvString.split("[,]");
            this.imageName = tokens[0];
            this.y = Integer.parseInt(tokens[1]);
            this.x = Integer.parseInt(tokens[2]);
            this.sy = Integer.parseInt(tokens[3]);
            this.sx = Integer.parseInt(tokens[4]);
            this.level = Integer.parseInt(tokens[5]);
            this.tileName = tokens[6];
            this.hasCells=false;
            this.brownCells=0;
            this.blueCells=0;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Tile(String imageName, int y, int x, int sy, int sx, int level, String tileName, boolean hasCells, double brownCells, double blueCells) {
        this.imageName = imageName;
        this.y = y;
        this.x = x;
        this.sy = sy;
        this.sx = sx;
        this.level = level;
        this.tileName = tileName;
        this.hasCells = hasCells;
        this.brownCells = brownCells;
        this.blueCells = blueCells;
    }

    public String makeCSVstring()
    {
        String result;
        result=this.imageName+',';
        result=result.concat(Integer.toString(this.y)+',');
        result=result.concat(Integer.toString(this.x)+',');
        result=result.concat(Integer.toString(this.sy)+',');
        result=result.concat(Integer.toString(this.sx)+',');
        result=result.concat(Integer.toString(this.level)+',');
        result=result.concat(this.tileName+',');

        result=result.concat(((this.hasCells == true) ? "1" : "0")+',');
        result=result.concat(Double.toString(this.brownCells)+',');
        result=result.concat(Double.toString(this.blueCells));

        return result;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public boolean isHasCells() {
        return hasCells;
    }

    public void setHasCells(boolean hasCells) {
        this.hasCells = hasCells;
    }

    public double getBrownCells() {
        return brownCells;
    }

    public void setBrownCells(double brownCells) {
        this.brownCells = brownCells;
    }

    public double getBlueCells() {
        return blueCells;
    }

    public void setBlueCells(double blueCells) {
        this.blueCells = blueCells;
    }
}
