package com.jvmsniffer.connections;

import com.jvmsniffer.BodyType;
import com.jvmsniffer.JvmSniffer;
import com.jvmsniffer.SnifferInputStream;
import com.jvmsniffer.SnifferOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.List;
import java.util.Map;



public class SnifferURLConnection extends URLConnection
{
    private URLConnection itsRealConnection;
    private BodyType itsOutputType;


    /**
     * Constructs a URL connection to the specified URL. A connection to
     * the object referenced by the URL is not created.
     *
     * @param aUrl the specified URL.
     * @param aRealConnection
     */
    public SnifferURLConnection(URL aUrl, URLConnection aRealConnection)
    {
        super(aUrl);
        itsRealConnection = aRealConnection;
    }


    @Override
    public void connect() throws IOException
    {
        itsRealConnection.connect();
    }

    @Override
    public void setConnectTimeout(int timeout)
    {
        itsRealConnection.setConnectTimeout(timeout);
    }

    @Override
    public int getConnectTimeout()
    {
        return itsRealConnection.getConnectTimeout();
    }

    @Override
    public void setReadTimeout(int timeout)
    {
        itsRealConnection.setReadTimeout(timeout);
    }

    @Override
    public int getReadTimeout()
    {
        return itsRealConnection.getReadTimeout();
    }

    @Override
    public URL getURL()
    {
        return itsRealConnection.getURL();
    }

    @Override
    public int getContentLength()
    {
        return itsRealConnection.getContentLength();
    }

    @Override
    public long getContentLengthLong()
    {
        return itsRealConnection.getContentLengthLong();
    }

    @Override
    public String getContentType()
    {
        return itsRealConnection.getContentType();
    }

    @Override
    public String getContentEncoding()
    {
        return itsRealConnection.getContentEncoding();
    }

    @Override
    public long getExpiration()
    {
        return itsRealConnection.getExpiration();
    }

    @Override
    public long getDate()
    {
        return itsRealConnection.getDate();
    }

    @Override
    public long getLastModified()
    {
        return itsRealConnection.getLastModified();
    }

    @Override
    public String getHeaderField(String name)
    {
        return itsRealConnection.getHeaderField(name);
    }

    @Override
    public Map<String, List<String>> getHeaderFields()
    {
        return itsRealConnection.getHeaderFields();
    }

    @Override
    public int getHeaderFieldInt(String name, int Default)
    {
        return itsRealConnection.getHeaderFieldInt(name, Default);
    }

    @Override
    public long getHeaderFieldLong(String name, long Default)
    {
        return itsRealConnection.getHeaderFieldLong(name, Default);
    }

    @Override
    public long getHeaderFieldDate(String name, long Default)
    {
        return itsRealConnection.getHeaderFieldDate(name, Default);
    }

    @Override
    public String getHeaderFieldKey(int n)
    {
        return itsRealConnection.getHeaderFieldKey(n);
    }

    @Override
    public String getHeaderField(int n)
    {
        return itsRealConnection.getHeaderField(n);
    }

    @Override
    public Object getContent() throws IOException
    {
        return itsRealConnection.getContent();
    }

    @Override
    public Object getContent(Class[] classes) throws IOException
    {
        return itsRealConnection.getContent(classes);
    }

    @Override
    public Permission getPermission() throws IOException
    {
        return itsRealConnection.getPermission();
    }

    @Override
    public InputStream getInputStream() throws IOException
    {
        if(itsOutputType == null)
        {
            itsOutputType = JvmSniffer.printRequestHeaders(itsRealConnection);
        }

        BodyType myBodyType = JvmSniffer.printResponseHeaders(itsRealConnection);
        return new SnifferInputStream(itsRealConnection.getInputStream(), myBodyType);
    }

    @Override
    public OutputStream getOutputStream() throws IOException
    {
        if(itsOutputType == null)
        {
            itsOutputType = JvmSniffer.printRequestHeaders(itsRealConnection);
        }

        return new SnifferOutputStream(itsRealConnection.getOutputStream(), itsOutputType);
    }

    @Override
    public String toString()
    {
        return itsRealConnection.toString();
    }

    @Override
    public void setDoInput(boolean doinput)
    {
        itsRealConnection.setDoInput(doinput);
    }

    @Override
    public boolean getDoInput()
    {
        return itsRealConnection.getDoInput();
    }

    @Override
    public void setDoOutput(boolean dooutput)
    {
        itsRealConnection.setDoOutput(dooutput);
    }

    @Override
    public boolean getDoOutput()
    {
        return itsRealConnection.getDoOutput();
    }

    @Override
    public void setAllowUserInteraction(boolean allowuserinteraction)
    {
        itsRealConnection.setAllowUserInteraction(allowuserinteraction);
    }

    @Override
    public boolean getAllowUserInteraction()
    {
        return itsRealConnection.getAllowUserInteraction();
    }

    @Override
    public void setUseCaches(boolean usecaches)
    {
        itsRealConnection.setUseCaches(usecaches);
    }

    @Override
    public boolean getUseCaches()
    {
        return itsRealConnection.getUseCaches();
    }

    @Override
    public void setIfModifiedSince(long ifmodifiedsince)
    {
        itsRealConnection.setIfModifiedSince(ifmodifiedsince);
    }

    @Override
    public long getIfModifiedSince()
    {
        return itsRealConnection.getIfModifiedSince();
    }

    @Override
    public boolean getDefaultUseCaches()
    {
        return itsRealConnection.getDefaultUseCaches();
    }

    @Override
    public void setDefaultUseCaches(boolean defaultusecaches)
    {
        itsRealConnection.setDefaultUseCaches(defaultusecaches);
    }

    @Override
    public void setRequestProperty(String key, String value)
    {
        itsRealConnection.setRequestProperty(key, value);
    }

    @Override
    public void addRequestProperty(String key, String value)
    {
        itsRealConnection.addRequestProperty(key, value);
    }

    @Override
    public String getRequestProperty(String key)
    {
        return itsRealConnection.getRequestProperty(key);
    }

    @Override
    public Map<String, List<String>> getRequestProperties()
    {
        return itsRealConnection.getRequestProperties();
    }
}
