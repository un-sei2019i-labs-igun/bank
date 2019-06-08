package com.example.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.LinkedList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity()
public class Account {
    @Id(autoincrement = true)
    private long nCuenta;

    private long userId;
    @NotNull
    private double balance;

    @ToOne(joinProperty = "userId")
    private User user;

    @ToMany(referencedJoinProperty = "senderId")
    private List<Transaction> senderTransactions;
    @ToMany(referencedJoinProperty = "receptorId")
    private List<Transaction> receptorTransactions;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 335469827)
    private transient AccountDao myDao;

    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    private Account(double balance){
        this.balance = balance;
        senderTransactions = new LinkedList<>();
        receptorTransactions = new LinkedList<>();
    }

    private Account(){
        this.balance = -1;
        senderTransactions = new LinkedList<>();
        receptorTransactions = new LinkedList<>();
    }

    @Generated(hash = 1300787925)
    public Account(long nCuenta, long userId, double balance) {
        this.nCuenta = nCuenta;
        this.userId = userId;
        this.balance = balance;
    }

    public long getNCuenta() {
        return this.nCuenta;
    }

    public void setNCuenta(long nCuenta) {
        this.nCuenta = nCuenta;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 115391908)
    public User getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 151665014)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException(
                    "To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getIdNumber();
            user__resolvedKey = userId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1276225609)
    public List<Transaction> getSenderTransactions() {
        if (senderTransactions == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TransactionDao targetDao = daoSession.getTransactionDao();
            List<Transaction> senderTransactionsNew = targetDao
                    ._queryAccount_SenderTransactions(nCuenta);
            synchronized (this) {
                if (senderTransactions == null) {
                    senderTransactions = senderTransactionsNew;
                }
            }
        }
        return senderTransactions;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 457367310)
    public synchronized void resetSenderTransactions() {
        senderTransactions = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1195662171)
    public List<Transaction> getReceptorTransactions() {
        if (receptorTransactions == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TransactionDao targetDao = daoSession.getTransactionDao();
            List<Transaction> receptorTransactionsNew = targetDao
                    ._queryAccount_ReceptorTransactions(nCuenta);
            synchronized (this) {
                if (receptorTransactions == null) {
                    receptorTransactions = receptorTransactionsNew;
                }
            }
        }
        return receptorTransactions;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 305979965)
    public synchronized void resetReceptorTransactions() {
        receptorTransactions = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1812283172)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAccountDao() : null;
    }

    /*public Transaction[] getTransactions() {
        List<Transaction> transaction = new LinkedList();
        transaction.addAll(senderTransactions);
        transaction.addAll(receptorTransactions);
        return transaction.toArray(new Transaction[transaction.size()]);
    }*/
}
