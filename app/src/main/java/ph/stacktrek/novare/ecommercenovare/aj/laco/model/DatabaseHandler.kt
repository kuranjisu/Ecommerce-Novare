package ph.stacktrek.novare.ecommercenovare.aj.laco.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import ph.stacktrek.novare.ecommercenovare.aj.laco.R
import java.io.File
import java.io.FileOutputStream

class DatabaseHandler(context: Context):
    SQLiteOpenHelper(context, DATABASENAME,null, DATABASEVERSION) {

    private val mContext = context

    companion object {
        private val DATABASEVERSION = 1
        private val DATABASENAME = "ProductsDatabase"

        const val TABLE_PRODUCT = "product_table"
        const val TABLE_PRODUCT_ID = "id"
        const val TABLE_PRODUCT_NAME = "name"
        const val TABLE_PRODUCT_PRICE = "price"
        const val TABLE_PRODUCT_BRAND = "brand"
        const val TABLE_PRODUCT_MEASUREMENT = "measurement"
        const val TABLE_PRODUCT_DESCRIPTION = "description"
        const val TABLE_PRODUCT_MEASUREMENT_UNIT = "measurement_unit"
        const val TABLE_PRODUCT_QUANTITY = "quantity"
        const val TABLE_PRODUCT_IMAGE_PATH = "path"
        const val TABLE_PRODUCT_IMAGE = "image"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PRODUCTS_TABLE =
            "CREATE TABLE $TABLE_PRODUCT " +
                    "($TABLE_PRODUCT_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$TABLE_PRODUCT_NAME TEXT, " +
                    "$TABLE_PRODUCT_PRICE REAL, " +
                    "$TABLE_PRODUCT_BRAND TEXT, " +
                    "$TABLE_PRODUCT_MEASUREMENT REAL, " +
                    "$TABLE_PRODUCT_DESCRIPTION TEXT, " +
                    "$TABLE_PRODUCT_MEASUREMENT_UNIT TEXT, " +
                    "$TABLE_PRODUCT_QUANTITY REAL, " +
                    "$TABLE_PRODUCT_IMAGE BLOB, " +
                    "$TABLE_PRODUCT_IMAGE_PATH TEXT)"


        db?.execSQL(CREATE_PRODUCTS_TABLE)


        val image = BitmapFactory.decodeResource(mContext.resources, R.drawable.edward)
        val file = File(mContext.filesDir, "edward.jpg")
        val fileOutputStream = FileOutputStream(file)
        image.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
        fileOutputStream.flush()
        fileOutputStream.close()

        val values = ContentValues()
        values.put(TABLE_PRODUCT_NAME, "Edward Scissorhands")
        values.put(TABLE_PRODUCT_IMAGE_PATH, file.absolutePath) // add new column for file path
        val id = db?.insert(TABLE_PRODUCT, null, values)

        val image2 = BitmapFactory.decodeResource(mContext.resources, R.drawable.travis)
        val file2 = File(mContext.filesDir, "travis.jpg")
        val fileOutputStream2 = FileOutputStream(file2)
        image2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2)
        fileOutputStream2.flush()
        fileOutputStream2.close()

        val values2 = ContentValues()
        values2.put(TABLE_PRODUCT_NAME, "Travis Bickle")
        values2.put(TABLE_PRODUCT_IMAGE_PATH, file2.absolutePath) // add new column for file path
        val id2 = db?.insert(TABLE_PRODUCT, null, values2)

        val image3 = BitmapFactory.decodeResource(mContext.resources, R.drawable.spike)
        val file3 = File(mContext.filesDir, "spike.jpg")
        val fileOutputStream3 = FileOutputStream(file3)
        image3.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream3)
        fileOutputStream3.flush()
        fileOutputStream3.close()

        val values3 = ContentValues()
        values3.put(TABLE_PRODUCT_NAME, "Spike Spiegel")
        values3.put(TABLE_PRODUCT_IMAGE_PATH, file3.absolutePath) // add new column for file path
        val id3 = db?.insert(TABLE_PRODUCT, null, values3)

        val image4 = BitmapFactory.decodeResource(mContext.resources, R.drawable.napoleon)
        val file4 = File(mContext.filesDir, "napoleon.jpg")
        val fileOutputStream4 = FileOutputStream(file4)
        image4.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream4)
        fileOutputStream4.flush()
        fileOutputStream4.close()

        val values4 = ContentValues()
        values4.put(TABLE_PRODUCT_NAME, "Napoleon Dynamite")
        values4.put(TABLE_PRODUCT_IMAGE_PATH, file4.absolutePath) // add new column for file path
        val id4 = db?.insert(TABLE_PRODUCT, null, values4)

        val image5 = BitmapFactory.decodeResource(mContext.resources, R.drawable.patrick)
        val file5 = File(mContext.filesDir, "patrick.jpg")
        val fileOutputStream5 = FileOutputStream(file5)
        image5.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream5)
        fileOutputStream5.flush()
        fileOutputStream5.close()

        val values5 = ContentValues()
        values5.put(TABLE_PRODUCT_NAME, "Patrick Bateman")
        values5.put(TABLE_PRODUCT_IMAGE_PATH, file5.absolutePath) // add new column for file path
        val id5 = db?.insert(TABLE_PRODUCT, null, values5)

        val image6 = BitmapFactory.decodeResource(mContext.resources, R.drawable.tyler)
        val file6 = File(mContext.filesDir, "tyler.jpg")
        val fileOutputStream6 = FileOutputStream(file6)
        image6.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream6)
        fileOutputStream6.flush()
        fileOutputStream6.close()

        val values6 = ContentValues()
        values6.put(TABLE_PRODUCT_NAME, "Patrick Bateman")
        values6.put(TABLE_PRODUCT_IMAGE_PATH, file6.absolutePath) // add new column for file path
        val id6 = db?.insert(TABLE_PRODUCT, null, values6)




    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCT")
        onCreate(db)
    }


}