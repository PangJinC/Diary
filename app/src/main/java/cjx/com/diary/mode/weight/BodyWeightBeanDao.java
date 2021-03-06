package cjx.com.diary.mode.weight;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cjx.com.diary.mode.diary.DaoSession;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BODY_WEIGHT_BEAN".
*/
public class BodyWeightBeanDao extends AbstractDao<BodyWeightBean, String> {

    public static final String TABLENAME = "BODY_WEIGHT_BEAN";

    /**
     * Properties of entity BodyWeightBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property MorningWeight = new Property(0, String.class, "morningWeight", true, "MORNING_WEIGHT");
        public final static Property NightWeight = new Property(1, String.class, "nightWeight", false, "NIGHT_WEIGHT");
        public final static Property CreatedDate = new Property(2, String.class, "createdDate", false, "CREATED_DATE");
    }


    public BodyWeightBeanDao(DaoConfig config) {
        super(config);
    }
    
    public BodyWeightBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BODY_WEIGHT_BEAN\" (" + //
                "\"MORNING_WEIGHT\" TEXT PRIMARY KEY NOT NULL ," + // 0: morningWeight
                "\"NIGHT_WEIGHT\" TEXT," + // 1: nightWeight
                "\"CREATED_DATE\" TEXT);"); // 2: createdDate
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_BODY_WEIGHT_BEAN_CREATED_DATE ON \"BODY_WEIGHT_BEAN\"" +
                " (\"CREATED_DATE\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BODY_WEIGHT_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BodyWeightBean entity) {
        stmt.clearBindings();
 
        String morningWeight = entity.getMorningWeight();
        if (morningWeight != null) {
            stmt.bindString(1, morningWeight);
        }
 
        String nightWeight = entity.getNightWeight();
        if (nightWeight != null) {
            stmt.bindString(2, nightWeight);
        }
 
        String createdDate = entity.getCreatedDate();
        if (createdDate != null) {
            stmt.bindString(3, createdDate);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BodyWeightBean entity) {
        stmt.clearBindings();
 
        String morningWeight = entity.getMorningWeight();
        if (morningWeight != null) {
            stmt.bindString(1, morningWeight);
        }
 
        String nightWeight = entity.getNightWeight();
        if (nightWeight != null) {
            stmt.bindString(2, nightWeight);
        }
 
        String createdDate = entity.getCreatedDate();
        if (createdDate != null) {
            stmt.bindString(3, createdDate);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public BodyWeightBean readEntity(Cursor cursor, int offset) {
        BodyWeightBean entity = new BodyWeightBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // morningWeight
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // nightWeight
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // createdDate
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BodyWeightBean entity, int offset) {
        entity.setMorningWeight(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setNightWeight(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCreatedDate(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final String updateKeyAfterInsert(BodyWeightBean entity, long rowId) {
        return entity.getMorningWeight();
    }
    
    @Override
    public String getKey(BodyWeightBean entity) {
        if(entity != null) {
            return entity.getMorningWeight();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BodyWeightBean entity) {
        return entity.getMorningWeight() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
