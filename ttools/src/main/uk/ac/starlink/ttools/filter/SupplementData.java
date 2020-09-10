package uk.ac.starlink.ttools.filter;

import java.io.IOException;

/**
 * Accessor for the data supplied by columns in an associated ColumnSupplement.
 * An instance of this class is returned from
 * {@link ColumnSupplement#createSupplementData} method.
 * Note that a RowSequence from a host table is associated with this
 * object, and the cell/row data supplied by this object is in general
 * generated by manipulating data orginally supplied by that underlying
 * row sequence.  In particular the data supplied by this object is
 * always from the <em>current</em> row of the underlying RowSequence;
 * the row index supplied to the getRow/getCell methods of this object
 * is additional information, it is <em>not</em> to be used to request
 * out of sequence values.
 *
 * @author   Mark Taylor
 * @since    2 Apr 2012
 * @see   ColumnSupplement
 */
public interface SupplementData {

    /**
     * Returns a cell value from the current row of this sequence.
     *
     * @param   irow  current index of the sequence;
     *                supplied for information only,
     *                and not to be used for random access
     * @param  icol  column index
     * @return   value of column <code>icol</code> at current sequence row
     */
    Object getCell( long irow, int icol ) throws IOException;

    /**
     * Returns an array of cell values giving the current row of this sequence.
     *
     * @param   irow  current index of the sequence;
     *                supplied for information only,
     *                and not to be used for random access
     * @return   current sequence row
     */
    Object[] getRow( long irow ) throws IOException;
}