<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<kml xmlns="http://www.opengis.net/kml/2.2"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://www.opengis.net/kml/2.2 http://schemas.opengis.net/kml/2.2.0/ogckml22.xsd">
			<Document>
  				<xsl:apply-templates select="geonames/geoname"/>
  			</Document>
  		</kml>
	</xsl:template>
	
	<xsl:template match="geoname">
		<Placemark>
  		<name><xsl:value-of select="name"/></name>
   		<description><xsl:value-of select="name"/> es una ciudad de <xsl:value-of select="countryName"/> </description>
   		<Point>
     		<coordinates><xsl:value-of select="lat"/>,<xsl:value-of select="lng"/></coordinates>
   		</Point>
   		</Placemark>
  	</xsl:template>
	
</xsl:stylesheet>