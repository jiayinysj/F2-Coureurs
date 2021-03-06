package backend;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Team implements Comparable<Team> {
    private String name;
    private String manager;
    private int budget;
    private int pointsAllTime;
    private int pointsThisSeason;
    private int winsAllTime;
    private int winsThisSeason;
    private Engine engine;
    private Aerodynamicist aerodynamicist;
    private Mechanic mechanic;
    private Strategist strategist;
    private List<Driver> drivers;

    /**
     * Create a new team.
     *
     * @param name the name of the team
     * @param manager the name of the manager
     * @param budget the current budget of this team
     * @param engine the engine of this team
     * @param aerodynamicist the aerodynamicist of this team
     * @param mechanic the mechanis of the team
     * @param strategist the strategist of the team
     */
    public Team(String name, String manager, int budget, Engine engine,
                Aerodynamicist aerodynamicist, Mechanic mechanic, Strategist strategist) {
        this.name = name;
        this.manager = manager;
        this.budget = budget;
        this.engine = engine;
        this.aerodynamicist = aerodynamicist;
        this.mechanic = mechanic;
        this.strategist = strategist;
        this.pointsAllTime = 0;
        this.pointsThisSeason = 0;
        this.winsAllTime = 0;
        this.winsThisSeason = 0;
        drivers = new ArrayList<Driver>();
    }

    /**
     * Get the name of the team.
     *
     * @return the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the team.
     *
     * @param name the name of the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the manager.
     *
     * @return the name of the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Set the name of the manager.
     *
     * @param manager the name of the manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Get the current budget.
     *
     * @return the current budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Gets a string representation of the budget minus the subtract amount.
     *
     * @param subtract the amount to subtract
     * @return a string of the budget
     */
    public String getBudgetString(int subtract) {
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return euroFormat.format(budget - subtract);
    }

    /**
     * Gets a string representation of the budget.
     *
     * @return string of the budget
     */
    public String getBudgetString() {
        return getBudgetString(0);
    }

    /**
     * Set the current budget.
     *
     * @param budget the current budget
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    /**
     * Get the total amount of points until now.
     *
     * @return the total amount pf points until now
     */
    public int getPointsAllTime() {
        return pointsAllTime;
    }

    /**
     * Set the total amount of points until now.
     *
     * @param pointsAllTime the total amount of points in this season
     */
    public void setPointsAllTime(int pointsAllTime) {
        this.pointsAllTime = pointsAllTime;
    }

    /**
     * Get the total amount of points in this season.
     *
     * @return the total amount of points in this season
     */
    public int getPointsThisSeason() {
        return pointsThisSeason;
    }

    /**
     * Set the total amount of points in this season.
     *
     * @param pointsThisSeason the total amount of points in this season
     */
    public void setPointsThisSeason(int pointsThisSeason) {
        this.pointsThisSeason = pointsThisSeason;
    }

    /**
     * Get the total amount of wins until now.
     *
     * @return the total amount of wins until now
     */
    public int getWinsAllTime() {
        return winsAllTime;
    }

    /**
     * Set the total amount of wins until now.
     *
     * @param winAllTime the value you want tot change
     */
    public void setWinsAllTime(int winAllTime) {
        this.winsAllTime = winAllTime;
    }

    /**
     * Get the total amount of wins in this season.
     *
     * @return the total amount of wins in this season
     */
    public int getWinsThisSeason() {
        return winsThisSeason;
    }

    /**
     * Set the total amount of wins in this season.
     *
     * @param winsThisSeason the total amount of wins in this season
     */
    public void setWinThisSeason(int winsThisSeason) {
        this.winsThisSeason = winsThisSeason;
    }

    /**
     * Get the engine.
     *
     * @return the engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Set the engine.
     *
     * @param engine the engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Changes the engine in game.
     *
     * @param engine the new engine
     */
    public void changeEngine(Engine engine) {
        this.engine = engine;
        budget -= engine.getPrice();
    }

    /**
     * Get the aerodynamicist.
     *
     * @return the aerodynamicist
     */
    public Aerodynamicist getAerodynamicist() {
        return aerodynamicist;
    }

    /**
     * Set the aerodynamicist.
     *
     * @param aerodynamicist the aerodynamicist
     */
    public void setAerodynamicist(Aerodynamicist aerodynamicist) {
        this.aerodynamicist = aerodynamicist;
    }

    /**
     * Get the mechanic.
     *
     * @return the mechanic
     */
    public Mechanic getMechanic() {
        return mechanic;
    }

    /**
     * Set the mechanic.
     *
     * @param mechanic the mechanic
     */
    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    /**
     * Get the strategist.
     *
     * @return the strategist
     */
    public Strategist getStrategist() {
        return strategist;
    }

    /**
     * Set the strategist.
     *
     * @param strategist the strategist
     */
    public void setStrategist(Strategist strategist) {
        this.strategist = strategist;
    }

    /**
     * Report on whether the list contains a staff member.
     *
     * @param staffMember the staff member to compare with
     * @return true if the staff member is in the team and false otherwise
     */
    public boolean contains(Staff staffMember) {
        for (Driver driver: drivers) {
            if (driver.equals(staffMember)) {
                return true;
            }
        }
        return aerodynamicist.equals(staffMember)
            || mechanic.equals(staffMember)
            || strategist.equals(staffMember);
    }

    /**
     * Swaps the staffMember in the argument for the existing staffmember.
     * Returns the old staff member.
     *
     * @param staffMember The new staff member in the team
     * @return the old staff member
     */
    public Staff swapStaffMember(Staff staffMember) {
        if (staffMember instanceof Aerodynamicist) {
            Aerodynamicist newAero = (Aerodynamicist) staffMember;
            Aerodynamicist oldAero = aerodynamicist;
            setAerodynamicist(newAero);
            return oldAero;
        } else if (staffMember instanceof Driver) {
            Driver newDriver = (Driver) staffMember;
            Driver oldDriver = getFirstDriver();
            setFirstDriver(newDriver);
            return oldDriver;
        } else if (staffMember instanceof Mechanic) {
            Mechanic newMechanic = (Mechanic) staffMember;
            Mechanic oldMechanic = mechanic;
            setMechanic(newMechanic);
            return oldMechanic;
        } else {
            Strategist newStrategist = (Strategist) staffMember;
            Strategist oldStrategist = strategist;
            setStrategist(newStrategist);
            return oldStrategist;
        }
    }

    /**
     * Swaps the driver in the argument to for the existing driver.
     *
     * @param driver the new driver
     * @return the old driver
     */
    public Driver swapSecondDriver(Driver driver) {
        Driver oldDriver = getSecondDriver();
        setSecondDriver(driver);
        return oldDriver;
    }

    /**
     * Sets the first Driver.
     *
     * @param driver the new Driver
     */
    public void setFirstDriver(Driver driver) {
        if (drivers.size() == 0) {
            drivers.add(driver);
        } else {
            drivers.set(0, driver);
        }
    }

    /**
     * Sets the second Driver.
     *
     * @param driver the new Driver
     */
    public void setSecondDriver(Driver driver) {
        if (drivers.size() <= 1) {
            drivers.add(driver);
        } else {
            drivers.set(1, driver);
        }
    }

    /**
     * Get the first driver.
     *
     * @return the first driver
     */
    public Driver getFirstDriver() {
        return drivers.get(0);
    }

    /**
     * Get the second driver.
     *
     * @return the second driver
     */
    public Driver getSecondDriver() {
        return drivers.get(1);
    }

    private boolean driversEquals(Team that) {
        if (this.drivers.size() != that.drivers.size()) {
            return false;
        }
        for (Driver driver : this.drivers) {
            if (!that.drivers.contains(driver)) {
                return false;
            }
        }
        return true;
    }

    private boolean metaDataEquals(Team that) {
        return that.pointsAllTime == this.pointsAllTime
            && that.pointsThisSeason == this.pointsThisSeason
            && that.winsAllTime == this.winsAllTime
            && that.winsThisSeason == this.winsThisSeason
            && that.budget == this.budget
            && that.name.equals(this.name);
    }

    private boolean staffEquals(Team that) {
        return that.manager.equals(this.manager)
            && that.engine.equals(this.engine)
            && that.aerodynamicist.equals(this.aerodynamicist)
            && that.mechanic.equals(this.mechanic)
            && that.strategist.equals(this.strategist);
    }

    /**
     * Report on whether or not the object is equal to team.
     *
     * @param other the object to compare with
     * @return true if they are equal and false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Team) {
            Team team = (Team) other;
            return metaDataEquals(team)
                && staffEquals(team)
                && driversEquals(team);
        }
        return false;
    }

    /**
     * Compares this object with the specified object for order.
     *
     * @param other the object to be compared
     * @return a negative integer, zero, or a positive integer as this object is less than,
     *         equal to, or greater than the specified object
     */
    @Override
    public int compareTo(Team other) {
        int comparePoints = other.pointsThisSeason;

        return comparePoints - this.pointsThisSeason;
    }
}
