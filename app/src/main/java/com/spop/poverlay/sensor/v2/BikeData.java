package com.spop.poverlay.sensor.v2;

import android.os.Parcel;
import android.os.Parcelable;

public class BikeData implements Parcelable {
    public static final Creator<BikeData> CREATOR = new Creator<BikeData>() {

        @Override // android.os.Parcelable.Creator
        public BikeData createFromParcel(Parcel parcel) {
            return new BikeData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BikeData[] newArray(int i) {
            return new BikeData[i];
        }
    };
    private int mADValue;
    private int mAppliedPositionOffset;
    private String mBikeFrameSerial;
    private int mCalibrationState;
    private int mCurrentResistance;
    private int mDataWriteCycle;
    private String mDataWriteDate;
    private String mDataWriteTime;
    private int mEncoderAngle;
    private int mError1Code;
    private String mError1Time;
    private int mError2Code;
    private String mError2Time;
    private int mError3Code;
    private String mError3Time;
    private int mError4Code;
    private String mError4Time;
    private int mError5Code;
    private String mError5Time;
    private int mErrorIndex;
    private int[] mErrorMap;
    private String mFWVersionNumber;
    private String mHardwareVersion;
    private int mLoadCellCalSpan;
    private float mLoadCellOffset;
    private long mLoadCellReading;
    private String mLoadCellSerial;
    private String mLoadCellTable;
    private int mLoadCellTableCrc;
    private int mLoadCellTableStatus;
    private int mLoadCellTempCount;
    private String mLoadCellVersion;
    private int mLoadCellZeroData;
    private String mPSerial;
    private int mPZAFMaxResistanceSetPoint;
    private int mPZAFMinUpdateRPM;
    private int mPZAFRampDownRate;
    private int mPZAFRampUpRate;
    private byte[] mPacketData;
    private String mPacketTime;
    private int mPositionOffset;
    private long mPower;
    private int mPowerZoneAutoFollowEnabled;
    private int mPowerZoneAutoFollowPowerSetPoint;
    private int mPowerZoneAutoFollowStatus;
    private float mPowerZoneAutoFollowTargetResistance;
    private String mQSerial;
    private long mRPM;
    private float mResistanceOffset;
    private int mStallThreshold;
    private int mStepperMotorEndPosition;
    private long mStepperMotorPosition;
    private int mStepperMotorStartPosition;
    private int mSystemState;
    private int mTargetResistance;
    private float mV1Resistance;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getRPM() {
        return this.mRPM;
    }

    public long getPower() {
        return this.mPower;
    }

    public long getStepperMotorPosition() {
        return this.mStepperMotorPosition;
    }

    public long getLoadCellReading() {
        return this.mLoadCellReading;
    }

    public int getCurrentResistance() {
        return this.mCurrentResistance;
    }

    public int getTargetResistance() {
        return this.mTargetResistance;
    }

    public String getPSerial() {
        return this.mPSerial;
    }

    public String getFWVersion() {
        return this.mFWVersionNumber;
    }

    public byte[] getPacketData() {
        return this.mPacketData;
    }

    public String getPacketTime() {
        return this.mPacketTime;
    }

    public int getStepperMotorStartPosition() {
        return this.mStepperMotorStartPosition;
    }

    public int getStepperMotorEndPosition() {
        return this.mStepperMotorEndPosition;
    }

    public int getCalibrationState() {
        return this.mCalibrationState;
    }

    public int getEncoderAngle() {
        return this.mEncoderAngle;
    }

    public void setRPM(long j) {
        this.mRPM = j;
    }

    public void setPower(long j) {
        this.mPower = j;
    }

    public void setStepperMotorPosition(long j) {
        this.mStepperMotorPosition = j;
    }

    public void setLoadCellReading(long j) {
        this.mLoadCellReading = j;
    }

    public void setCurrentResistance(int i) {
        this.mCurrentResistance = i;
    }

    public void setTargetResistance(int i) {
        this.mTargetResistance = i;
    }

    public void setPSerial(String str) {
        this.mPSerial = str;
    }

    public void setFirmWareVersion(String str) {
        this.mFWVersionNumber = str;
    }

    public void setPacketData(byte[] bArr) {
        this.mPacketData = bArr;
    }

    public void setPacketTime(String str) {
        this.mPacketTime = str;
    }

    public void setStepperMotorStartPosition(int i) {
        this.mStepperMotorStartPosition = i;
    }

    public void setStepperMotorEndPosition(int i) {
        this.mStepperMotorEndPosition = i;
    }

    public void setCalibrationState(int i) {
        this.mCalibrationState = i;
    }

    public void setEncoderAngle(int i) {
        this.mEncoderAngle = i;
    }

    public int getLoadCellTableStatus() {
        return this.mLoadCellTableStatus;
    }

    public void setLoadCellTableStatus(int i) {
        this.mLoadCellTableStatus = i;
    }

    public int getSystemState() {
        return this.mSystemState;
    }

    public void setSystemState(int i) {
        this.mSystemState = i;
    }

    public int getErrorIndex() {
        return this.mErrorIndex;
    }

    public void setErrorIndex(int i) {
        this.mErrorIndex = i;
    }

    public int getError1Code() {
        return this.mError1Code;
    }

    public void setError1Code(int i) {
        this.mError1Code = i;
    }

    public String getError1Time() {
        return this.mError1Time;
    }

    public void setError1Time(String str) {
        this.mError1Time = str;
    }

    public int getError2Code() {
        return this.mError2Code;
    }

    public void setError2Code(int i) {
        this.mError2Code = i;
    }

    public String getError2Time() {
        return this.mError2Time;
    }

    public void setError2Time(String str) {
        this.mError2Time = str;
    }

    public int getError3Code() {
        return this.mError3Code;
    }

    public void setError3Code(int i) {
        this.mError3Code = i;
    }

    public String getError3Time() {
        return this.mError3Time;
    }

    public void setError3Time(String str) {
        this.mError3Time = str;
    }

    public int getError4Code() {
        return this.mError4Code;
    }

    public void setError4Code(int i) {
        this.mError4Code = i;
    }

    public String getError4Time() {
        return this.mError4Time;
    }

    public void setError4Time(String str) {
        this.mError4Time = str;
    }

    public int getError5Code() {
        return this.mError5Code;
    }

    public void setError5Code(int i) {
        this.mError5Code = i;
    }

    public String getError5Time() {
        return this.mError5Time;
    }

    public void setError5Time(String str) {
        this.mError5Time = str;
    }

    public int[] getErrorMap() {
        return this.mErrorMap;
    }

    public void setErrorMap(int[] iArr) {
        if (iArr.length < 15) {
            return;
        }
        this.mErrorMap = iArr;
    }

    public String getLoadCellTable() {
        return this.mLoadCellTable;
    }

    public void setLoadCellTable(String str) {
        this.mLoadCellTable = str;
    }

    public int getLoadCellTableCrc() {
        return this.mLoadCellTableCrc;
    }

    public void setLoadCellTableCrc(int i) {
        this.mLoadCellTableCrc = i;
    }

    public String getQSerial() {
        return this.mQSerial;
    }

    public void setQSerial(String str) {
        this.mQSerial = str;
    }

    public String getBikeFrameSerial() {
        return this.mBikeFrameSerial;
    }

    public void setBikeFrameSerial(String str) {
        this.mBikeFrameSerial = str;
    }

    public String getLoadCellSerial() {
        return this.mLoadCellSerial;
    }

    public void setLoadCellSerial(String str) {
        this.mLoadCellSerial = str;
    }

    public float getLoadCellOffset() {
        return this.mLoadCellOffset;
    }

    public void setLoadCellOffset(float f) {
        this.mLoadCellOffset = f;
    }

    public int getDataWriteCycle() {
        return this.mDataWriteCycle;
    }

    public void setDataWriteCycle(int i) {
        this.mDataWriteCycle = i;
    }

    public String getDataWriteDate() {
        return this.mDataWriteDate;
    }

    public void setDataWriteDate(String str) {
        this.mDataWriteDate = str;
    }

    public String getDataWriteTime() {
        return this.mDataWriteTime;
    }

    public void setDataWriteTime(String str) {
        this.mDataWriteTime = str;
    }

    public int getLoadCellZeroData() {
        return this.mLoadCellZeroData;
    }

    public void setLoadCellZeroData(int i) {
        this.mLoadCellZeroData = i;
    }

    public int getLoadCellCalSpan() {
        return this.mLoadCellCalSpan;
    }

    public void setLoadCellCalSpan(int i) {
        this.mLoadCellCalSpan = i;
    }

    public int getLoadCellTempCount() {
        return this.mLoadCellTempCount;
    }

    public void setLoadCellTempCount(int i) {
        this.mLoadCellTempCount = i;
    }

    public float getResistanceOffset() {
        return this.mResistanceOffset;
    }

    public void setResistanceOffset(float f) {
        this.mResistanceOffset = f;
    }

    public int getPositionOffset() {
        return this.mPositionOffset;
    }

    public void setPositionOffset(int i) {
        this.mPositionOffset = i;
    }

    public float getV1Resistance() {
        return this.mV1Resistance;
    }

    public void setV1Resistance(float f) {
        this.mV1Resistance = f;
    }

    public String getLoadCellVersion() {
        return this.mLoadCellVersion;
    }

    public void setLoadCellVersion(String str) {
        this.mLoadCellVersion = str;
    }

    public int getAppliedPositionOffset() {
        return this.mAppliedPositionOffset;
    }

    public void setAppliedPositionOffset(int i) {
        this.mAppliedPositionOffset = i;
    }

    public int getStallThreshold() {
        return this.mStallThreshold;
    }

    public void setStallThreshold(int i) {
        this.mStallThreshold = i;
    }

    public String getHardwareVersion() {
        return this.mHardwareVersion;
    }

    public void setHardwareVersion(String str) {
        this.mHardwareVersion = str;
    }

    public int getADValue() {
        return this.mADValue;
    }

    public void setADValue(int i) {
        this.mADValue = i;
    }

    public int getPowerZoneAutoFollowEnabled() {
        return this.mPowerZoneAutoFollowEnabled;
    }

    public void setPowerZoneAutoFollowEnabled(int i) {
        this.mPowerZoneAutoFollowEnabled = i;
    }

    public int getPowerZoneAutoFollowPowerSetPoint() {
        return this.mPowerZoneAutoFollowPowerSetPoint;
    }

    public void setPowerZoneAutoFollowPowerSetPoint(int i) {
        this.mPowerZoneAutoFollowPowerSetPoint = i;
    }

    public float getPowerZoneAutoFollowTargetResistance() {
        return this.mPowerZoneAutoFollowTargetResistance;
    }

    public void setPowerZoneAutoFollowTargetResistance(float f) {
        this.mPowerZoneAutoFollowTargetResistance = f;
    }

    public int getPowerZoneAutoFollowStatus() {
        return this.mPowerZoneAutoFollowStatus;
    }

    public void setPowerZoneAutoFollowStatus(int i) {
        this.mPowerZoneAutoFollowStatus = i;
    }

    public int getPZAFRampUpRate() {
        return this.mPZAFRampUpRate;
    }

    public void setPZAFRampUpRate(int i) {
        this.mPZAFRampUpRate = i;
    }

    public int getPZAFRampDownRate() {
        return this.mPZAFRampDownRate;
    }

    public void setPZAFRampDownRate(int i) {
        this.mPZAFRampDownRate = i;
    }

    public int getPZAFMaxResistanceSetPoint() {
        return this.mPZAFMaxResistanceSetPoint;
    }

    public void setPZAFMaxResistanceSetPoint(int i) {
        this.mPZAFMaxResistanceSetPoint = i;
    }

    public int getPZAFMinUpdateRPM() {
        return this.mPZAFMinUpdateRPM;
    }

    public void setPZAFMinUpdateRPM(int i) {
        this.mPZAFMinUpdateRPM = i;
    }

    private BikeData(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mRPM);
        parcel.writeLong(this.mPower);
        parcel.writeLong(this.mStepperMotorPosition);
        parcel.writeLong(this.mLoadCellReading);
        parcel.writeInt(this.mCurrentResistance);
        parcel.writeInt(this.mTargetResistance);
        parcel.writeString(this.mFWVersionNumber);
        parcel.writeByteArray(this.mPacketData);
        parcel.writeString(this.mPacketTime);
        parcel.writeInt(this.mStepperMotorStartPosition);
        parcel.writeInt(this.mStepperMotorEndPosition);
        parcel.writeInt(this.mCalibrationState);
        parcel.writeInt(this.mEncoderAngle);
        parcel.writeInt(this.mSystemState);
        parcel.writeInt(this.mErrorIndex);
        parcel.writeInt(this.mError1Code);
        parcel.writeString(this.mError1Time);
        parcel.writeInt(this.mError2Code);
        parcel.writeString(this.mError2Time);
        parcel.writeInt(this.mError3Code);
        parcel.writeString(this.mError3Time);
        parcel.writeInt(this.mError4Code);
        parcel.writeString(this.mError4Time);
        parcel.writeInt(this.mError5Code);
        parcel.writeString(this.mError5Time);
        parcel.writeIntArray(this.mErrorMap);
        parcel.writeString(this.mLoadCellTable);
        parcel.writeInt(this.mLoadCellTableCrc);
        parcel.writeString(this.mPSerial);
        parcel.writeString(this.mQSerial);
        parcel.writeString(this.mBikeFrameSerial);
        parcel.writeString(this.mLoadCellSerial);
        parcel.writeFloat(this.mLoadCellOffset);
        parcel.writeInt(this.mDataWriteCycle);
        parcel.writeString(this.mDataWriteDate);
        parcel.writeString(this.mDataWriteTime);
        parcel.writeInt(this.mLoadCellZeroData);
        parcel.writeInt(this.mLoadCellCalSpan);
        parcel.writeInt(this.mLoadCellTempCount);
        parcel.writeFloat(this.mResistanceOffset);
        parcel.writeInt(this.mPositionOffset);
        parcel.writeInt(this.mLoadCellTableStatus);
        parcel.writeFloat(this.mV1Resistance);
        parcel.writeString(this.mLoadCellVersion);
        parcel.writeInt(this.mAppliedPositionOffset);
        parcel.writeInt(this.mStallThreshold);
        parcel.writeString(this.mHardwareVersion);
        parcel.writeInt(this.mADValue);
        parcel.writeInt(this.mPowerZoneAutoFollowEnabled);
        parcel.writeInt(this.mPowerZoneAutoFollowPowerSetPoint);
        parcel.writeFloat(this.mPowerZoneAutoFollowTargetResistance);
        parcel.writeInt(this.mPowerZoneAutoFollowStatus);
        parcel.writeInt(this.mPZAFRampUpRate);
        parcel.writeInt(this.mPZAFRampDownRate);
        parcel.writeInt(this.mPZAFMaxResistanceSetPoint);
        parcel.writeInt(this.mPZAFMinUpdateRPM);
    }

    private void readFromParcel(Parcel parcel) {
        this.mRPM = parcel.readLong();
        this.mPower = parcel.readLong();
        this.mStepperMotorPosition = parcel.readLong();
        this.mLoadCellReading = parcel.readLong();
        this.mCurrentResistance = parcel.readInt();
        this.mTargetResistance = parcel.readInt();
        this.mFWVersionNumber = parcel.readString();
        this.mPacketData = parcel.createByteArray();
        this.mPacketTime = parcel.readString();
        this.mStepperMotorStartPosition = parcel.readInt();
        this.mStepperMotorEndPosition = parcel.readInt();
        this.mCalibrationState = parcel.readInt();
        this.mEncoderAngle = parcel.readInt();
        this.mSystemState = parcel.readInt();
        this.mErrorIndex = parcel.readInt();
        this.mError1Code = parcel.readInt();
        this.mError1Time = parcel.readString();
        this.mError2Code = parcel.readInt();
        this.mError2Time = parcel.readString();
        this.mError3Code = parcel.readInt();
        this.mError3Time = parcel.readString();
        this.mError4Code = parcel.readInt();
        this.mError4Time = parcel.readString();
        this.mError5Code = parcel.readInt();
        this.mError5Time = parcel.readString();
        int[] iArr = new int[15];
        this.mErrorMap = iArr;
        parcel.readIntArray(iArr);
        this.mLoadCellTable = parcel.readString();
        this.mLoadCellTableCrc = parcel.readInt();
        this.mPSerial = parcel.readString();
        this.mQSerial = parcel.readString();
        this.mBikeFrameSerial = parcel.readString();
        this.mLoadCellSerial = parcel.readString();
        this.mLoadCellOffset = parcel.readFloat();
        this.mDataWriteCycle = parcel.readInt();
        this.mDataWriteDate = parcel.readString();
        this.mDataWriteTime = parcel.readString();
        this.mLoadCellZeroData = parcel.readInt();
        this.mLoadCellCalSpan = parcel.readInt();
        this.mLoadCellTempCount = parcel.readInt();
        this.mResistanceOffset = parcel.readFloat();
        this.mPositionOffset = parcel.readInt();
        this.mLoadCellTableStatus = parcel.readInt();
        this.mV1Resistance = parcel.readFloat();
        this.mLoadCellVersion = parcel.readString();
        this.mAppliedPositionOffset = parcel.readInt();
        this.mStallThreshold = parcel.readInt();
        this.mHardwareVersion = parcel.readString();
        this.mADValue = parcel.readInt();
        this.mPowerZoneAutoFollowEnabled = parcel.readInt();
        this.mPowerZoneAutoFollowPowerSetPoint = parcel.readInt();
        this.mPowerZoneAutoFollowTargetResistance = parcel.readFloat();
        this.mPowerZoneAutoFollowStatus = parcel.readInt();
        this.mPZAFRampUpRate = parcel.readInt();
        this.mPZAFRampDownRate = parcel.readInt();
        this.mPZAFMaxResistanceSetPoint = parcel.readInt();
        this.mPZAFMinUpdateRPM = parcel.readInt();
    }
}
