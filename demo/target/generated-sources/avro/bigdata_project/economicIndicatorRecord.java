/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package bigdata_project;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class economicIndicatorRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5687424854337985586L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"economicIndicatorRecord\",\"namespace\":\"bigdata_project\",\"fields\":[{\"name\":\"date\",\"type\":\"long\",\"logicalType\":\"date\"},{\"name\":\"value\",\"type\":[\"double\",\"null\"]},{\"name\":\"interval\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<economicIndicatorRecord> ENCODER =
      new BinaryMessageEncoder<economicIndicatorRecord>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<economicIndicatorRecord> DECODER =
      new BinaryMessageDecoder<economicIndicatorRecord>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<economicIndicatorRecord> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<economicIndicatorRecord> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<economicIndicatorRecord> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<economicIndicatorRecord>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this economicIndicatorRecord to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a economicIndicatorRecord from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a economicIndicatorRecord instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static economicIndicatorRecord fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long date;
   private java.lang.Double value;
   private java.lang.String interval;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public economicIndicatorRecord() {}

  /**
   * All-args constructor.
   * @param date The new value for date
   * @param value The new value for value
   * @param interval The new value for interval
   */
  public economicIndicatorRecord(java.lang.Long date, java.lang.Double value, java.lang.String interval) {
    this.date = date;
    this.value = value;
    this.interval = interval;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return date;
    case 1: return value;
    case 2: return interval;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: date = (java.lang.Long)value$; break;
    case 1: value = (java.lang.Double)value$; break;
    case 2: interval = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'date' field.
   * @return The value of the 'date' field.
   */
  public long getDate() {
    return date;
  }



  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public java.lang.Double getValue() {
    return value;
  }



  /**
   * Gets the value of the 'interval' field.
   * @return The value of the 'interval' field.
   */
  public java.lang.String getInterval() {
    return interval;
  }



  /**
   * Creates a new economicIndicatorRecord RecordBuilder.
   * @return A new economicIndicatorRecord RecordBuilder
   */
  public static bigdata_project.economicIndicatorRecord.Builder newBuilder() {
    return new bigdata_project.economicIndicatorRecord.Builder();
  }

  /**
   * Creates a new economicIndicatorRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new economicIndicatorRecord RecordBuilder
   */
  public static bigdata_project.economicIndicatorRecord.Builder newBuilder(bigdata_project.economicIndicatorRecord.Builder other) {
    if (other == null) {
      return new bigdata_project.economicIndicatorRecord.Builder();
    } else {
      return new bigdata_project.economicIndicatorRecord.Builder(other);
    }
  }

  /**
   * Creates a new economicIndicatorRecord RecordBuilder by copying an existing economicIndicatorRecord instance.
   * @param other The existing instance to copy.
   * @return A new economicIndicatorRecord RecordBuilder
   */
  public static bigdata_project.economicIndicatorRecord.Builder newBuilder(bigdata_project.economicIndicatorRecord other) {
    if (other == null) {
      return new bigdata_project.economicIndicatorRecord.Builder();
    } else {
      return new bigdata_project.economicIndicatorRecord.Builder(other);
    }
  }

  /**
   * RecordBuilder for economicIndicatorRecord instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<economicIndicatorRecord>
    implements org.apache.avro.data.RecordBuilder<economicIndicatorRecord> {

    private long date;
    private java.lang.Double value;
    private java.lang.String interval;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(bigdata_project.economicIndicatorRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.interval)) {
        this.interval = data().deepCopy(fields()[2].schema(), other.interval);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing economicIndicatorRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(bigdata_project.economicIndicatorRecord other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.interval)) {
        this.interval = data().deepCopy(fields()[2].schema(), other.interval);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'date' field.
      * @return The value.
      */
    public long getDate() {
      return date;
    }


    /**
      * Sets the value of the 'date' field.
      * @param value The value of 'date'.
      * @return This builder.
      */
    public bigdata_project.economicIndicatorRecord.Builder setDate(long value) {
      validate(fields()[0], value);
      this.date = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'date' field has been set.
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'date' field.
      * @return This builder.
      */
    public bigdata_project.economicIndicatorRecord.Builder clearDate() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public java.lang.Double getValue() {
      return value;
    }


    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public bigdata_project.economicIndicatorRecord.Builder setValue(java.lang.Double value) {
      validate(fields()[1], value);
      this.value = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public bigdata_project.economicIndicatorRecord.Builder clearValue() {
      value = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'interval' field.
      * @return The value.
      */
    public java.lang.String getInterval() {
      return interval;
    }


    /**
      * Sets the value of the 'interval' field.
      * @param value The value of 'interval'.
      * @return This builder.
      */
    public bigdata_project.economicIndicatorRecord.Builder setInterval(java.lang.String value) {
      validate(fields()[2], value);
      this.interval = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'interval' field has been set.
      * @return True if the 'interval' field has been set, false otherwise.
      */
    public boolean hasInterval() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'interval' field.
      * @return This builder.
      */
    public bigdata_project.economicIndicatorRecord.Builder clearInterval() {
      interval = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public economicIndicatorRecord build() {
      try {
        economicIndicatorRecord record = new economicIndicatorRecord();
        record.date = fieldSetFlags()[0] ? this.date : (java.lang.Long) defaultValue(fields()[0]);
        record.value = fieldSetFlags()[1] ? this.value : (java.lang.Double) defaultValue(fields()[1]);
        record.interval = fieldSetFlags()[2] ? this.interval : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<economicIndicatorRecord>
    WRITER$ = (org.apache.avro.io.DatumWriter<economicIndicatorRecord>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<economicIndicatorRecord>
    READER$ = (org.apache.avro.io.DatumReader<economicIndicatorRecord>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.date);

    if (this.value == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeDouble(this.value);
    }

    out.writeString(this.interval);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.date = in.readLong();

      if (in.readIndex() != 0) {
        in.readNull();
        this.value = null;
      } else {
        this.value = in.readDouble();
      }

      this.interval = in.readString();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.date = in.readLong();
          break;

        case 1:
          if (in.readIndex() != 0) {
            in.readNull();
            this.value = null;
          } else {
            this.value = in.readDouble();
          }
          break;

        case 2:
          this.interval = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










