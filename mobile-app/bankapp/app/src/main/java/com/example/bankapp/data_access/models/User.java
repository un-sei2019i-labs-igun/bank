package com.example.bankapp.data_access.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity()
public class User{
    @Id()
    private long idNumber;

    @NotNull
    private String fullName;

    @NotNull
    private String password;

    @NotNull
    private Date lastPasswordChange;

    private long accountId;
    
    @ToOne(joinProperty = "accountId")
    private Account account;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 1501133588)
    private transient Long account__resolvedKey;

    public User(){
        this.fullName = "";
        this.password = "";
        this.idNumber = -1;
        this.lastPasswordChange = new Date(0);
    }

    @Generated(hash = 1606482342)
    public User(long idNumber, @NotNull String fullName, @NotNull String password,
            @NotNull Date lastPasswordChange, long accountId) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.password = password;
        this.lastPasswordChange = lastPasswordChange;
        this.accountId = accountId;
    }

    public long getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getLastPasswordChange() {
        return this.lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2143533054)
    public Account getAccount() {
        long __key = this.accountId;
        if (account__resolvedKey == null || !account__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AccountDao targetDao = daoSession.getAccountDao();
            Account accountNew = targetDao.load(__key);
            synchronized (this) {
                account = accountNew;
                account__resolvedKey = __key;
            }
        }
        return account;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 359752597)
    public void setAccount(@NotNull Account account) {
        if (account == null) {
            throw new DaoException(
                    "To-one property 'accountId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.account = account;
            accountId = account.getNCuenta();
            account__resolvedKey = accountId;
        }
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

}
