package hu.progmatic.oop_02_generics;

public class ChangeTracker<T> {
    private T lastVersion;
    private int changes;

    public void addVersion(T version) {
        if (lastVersion == null || !lastVersion.equals(version)) {
            changes++;
        }

        lastVersion = version;
    }

    public T getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(T lastVersion) {
        this.lastVersion = lastVersion;
    }

    public int getChanges() {
        return changes;
    }

    public void setChanges(int changes) {
        this.changes = changes;
    }
}
