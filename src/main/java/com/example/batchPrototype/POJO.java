package com.example.batchPrototype;

public class POJO
{
  String msidn;

  String imsi;

  String imei;

  String plan;

  String call_type;

  String corresp_type;

  String corresp_isdn;

  long duration;

  String time;

  String date;

  public String getMsidn()
  {
    return msidn;
  }

  public void setMsidn(String msidn)
  {
    this.msidn = msidn;
  }

  public String getImsi()
  {
    return imsi;
  }

  public void setImsi(String imsi)
  {
    this.imsi = imsi;
  }

  public String getImei()
  {
    return imei;
  }

  public void setImei(String imei)
  {
    this.imei = imei;
  }

  public String getPlan()
  {
    return plan;
  }

  public void setPlan(String plan)
  {
    this.plan = plan;
  }

  public String getCall_type()
  {
    return call_type;
  }

  public void setCall_type(String call_type)
  {
    this.call_type = call_type;
  }

  public String getCorresp_type()
  {
    return corresp_type;
  }

  public void setCorresp_type(String corresp_type)
  {
    this.corresp_type = corresp_type;
  }

  public String getCorresp_isdn()
  {
    return corresp_isdn;
  }

  public void setCorresp_isdn(String corresp_isdn)
  {
    this.corresp_isdn = corresp_isdn;
  }

  public long getDuration()
  {
    return duration;
  }

  public void setDuration(long duration)
  {
    this.duration = duration;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  @Override
  public String toString()
  {
    return "POJO [msidn=" + msidn + ", imsi=" + imsi + ", imei=" + imei + ", plan=" + plan + ", call_type=" + call_type
        + ", corresp_type=" + corresp_type + ", corresp_isdn=" + corresp_isdn + ", duration=" + duration + ", time="
        + time + ", date=" + date + "]";
  }

}
