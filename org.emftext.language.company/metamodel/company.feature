<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="Company Features">
  <root minCardinality="1" maxCardinality="1" name="Company">
    <groups maxCardinality="2">
      <childFeatures maxCardinality="1" name="Mentors"/>
      <childFeatures maxCardinality="1" name="Operations">
        <groups maxCardinality="3">
          <childFeatures maxCardinality="1" name="Cut"/>
          <childFeatures maxCardinality="1" name="Total"/>
          <childFeatures maxCardinality="1" name="Depth"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
