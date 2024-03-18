/*
 * Copyright (C) 2024 GROUP ANDBANK - All Rights Reserved
 *
 * This source code is protected under international copyright law.  All rights
 * reserved and protected by the copyright holders.
 * This file is confidential and only available to authorized individuals with the
 * permission of the copyright holders.  If you encounter this file and do not have
 * permission, please contact the copyright holders and delete this file.
 */
package com.andbank.emir;

/**
 * Emir Refit Columns.
 * 
 * @author luis.aguilar@devone.es
 * @version 1.0.1
 */
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmirRefitColumns {

	private static Logger logger = LoggerFactory.getLogger(EmirRefitColumns.class);

	private static final Set<String> COLUMN_NAMES = ConcurrentHashMap.newKeySet();

	private EmirRefitColumns() {
		// Utility class
	}

	public static final String ACTION_TYPE = "Action type";
	public static final String ASSET_CLASS = "Asset class";
	public static final String BASE_PRODUCT = "Base product";
	public static final String BROKER_ID = "Broker ID";
	public static final String CDS_INDEX_ATTACHMENT_POINT = "CDS index attachment point";
	public static final String CDS_INDEX_DETACHMENT_POINT = "CDS index detachment point";
	public static final String CENTRAL_COUNTERPARTY = "Central counterparty";
	public static final String CLEARED = "Cleared";
	public static final String CLEARING_MEMBER = "Clearing member";
	public static final String CLEARING_OBLIGATION = "Clearing obligation";
	public static final String CLEARING_THRESHOLD_OF_COUNTERPARTY_1 = "Clearing threshold of counterparty 1";
	public static final String CLEARING_THRESHOLD_OF_THE_COUNTERPARTY_2 = "Clearing threshold of the counterparty 2";
	public static final String CLEARING_TIMESTAMP = "Clearing timestamp";
	public static final String COLLATERAL_PORTFOLIO_CODE = "Collateral portfolio code";
	public static final String COLLATERAL_PORTFOLIO_INDICATOR = "Collateral portfolio indicator";
	public static final String COLLATERAL_TIMESTAMP = "Collateral timestamp";
	public static final String COLLATERALISATION_CATEGORY = "Collateralisation category";
	public static final String CONFIRMATION_TIMESTAMP = "Confirmation timestamp";
	public static final String CONFIRMED = "Confirmed";
	public static final String CONTRACT_TYPE = "Contract type";
	public static final String CORPORATE_SECTOR_OF_THE_COUNTERPARTY_1 = "Corporate sector of the counterparty 1";
	public static final String CORPORATE_SECTOR_OF_THE_COUNTERPARTY_2 = "Corporate sector of the counterparty 2";
	public static final String COUNTERPARTY_1_REPORTING_COUNTERPARTY = "Counterparty 1 (Reporting counterparty)";
	public static final String COUNTERPARTY_2 = "Counterparty 2";
	public static final String COUNTERPARTY_2_IDENTIFIER_TYPE = "Counterparty 2 identifier type";
	public static final String COUNTRY_OF_THE_COUNTERPARTY_2 = "Country of the counterparty 2";
	public static final String CURRENCY_OF_EXCESS_COLLATERAL_COLLECTED = "Currency of excess collateral collected";
	public static final String CURRENCY_OF_INITIAL_MARGIN_COLLECTED = "Currency of initial margin collected";
	public static final String CURRENCY_OF_THE_EXCESS_COLLATERAL_POSTED = "Currency of the excess collateral posted";
	public static final String CURRENCY_OF_THE_INITIAL_MARGIN_POSTED = "Currency of the initial margin posted";
	public static final String CURRENCY_OF_THE_PRICE_TIME_INTERVAL_QUANTITY = "Currency of the price/time interval quantity";
	public static final String CURRENCY_OF_THE_VARIATION_MARGINS_POSTED = "Currency of the variation margins posted";
	public static final String CURRENCY_OF_VARIATION_MARGIN_COLLECTED = "Currency of variation margin collected";
	public static final String CUSTOM_BASKET_CODE = "Custom basket code";
	public static final String DAYS_OF_THE_WEEK = "Days of the week";
	public static final String DELIVERY_CAPACITY = "Delivery capacity";
	public static final String DELIVERY_END_DATE = "Delivery end date";
	public static final String DELIVERY_INTERVAL_END_TIME = "Delivery interval end time";
	public static final String DELIVERY_INTERVAL_START_TIME = "Delivery interval start time";
	public static final String DELIVERY_POINT_OR_ZONE = "Delivery point or zone";
	public static final String DELIVERY_START_DATE = "Delivery start date";
	public static final String DELIVERY_TYPE = "Delivery type";
	public static final String DELTA = "Delta";
	public static final String DERIVATIVE_BASED_ON_CRYPTO_ASSETS = "Derivative based on crypto-assets";
	public static final String DIRECTION = "Direction";
	public static final String DIRECTION_OF_LEG_1 = "Direction of leg 1";
	public static final String DIRECTION_OF_LEG_2 = "Direction of leg 2";
	public static final String DIRECTLY_LINKED_TO_COMMERCIAL_ACTIVITY_OR_TREASURY_FINANCING = "Directly linked to commercial activity or treasury financing";
	public static final String DURATION = "Duration";
	public static final String EARLY_TERMINATION_DATE = "Early termination date";
	public static final String EFFECTIVE_DATE = "Effective date";
	public static final String EFFECTIVE_DATE_OF_THE_NOTIONAL_AMOUNT_OF_LEG_1 = "Effective date of the notional amount of leg 1";
	public static final String EFFECTIVE_DATE_OF_THE_NOTIONAL_AMOUNT_OF_LEG_2 = "Effective date of the notional amount of leg 2";
	public static final String EFFECTIVE_DATE_OF_THE_NOTIONAL_QUANTITY_OF_LEG_1 = "Effective date of the notional quantity of leg 1";
	public static final String EFFECTIVE_DATE_OF_THE_NOTIONAL_QUANTITY_OF_LEG_2 = "Effective date of the notional quantity of leg 2";
	public static final String EFFECTIVE_DATE_OF_THE_STRIKE_PRICE = "Effective date of the strike price";
	public static final String END_DATE_OF_THE_NOTIONAL_AMOUNT_OF_LEG_1 = "End date of the notional amount of leg 1";
	public static final String END_DATE_OF_THE_NOTIONAL_AMOUNT_OF_LEG_2 = "End date of the notional amount of leg 2";
	public static final String END_DATE_OF_THE_NOTIONAL_QUANTITY_OF_LEG_1 = "End date of the notional quantity of leg 1";
	public static final String END_DATE_OF_THE_NOTIONAL_QUANTITY_OF_LEG_2 = "End date of the notional quantity of leg 2";
	public static final String END_DATE_OF_THE_STRIKE_PRICE = "End date of the strike price";
	public static final String ENTITY_RESPONSIBLE_FOR_REPORTING = "Entity responsible for reporting";
	public static final String EVENT_DATE = "Event date";
	public static final String EVENT_TYPE = "Event type";
	public static final String EXCESS_COLLATERAL_COLLECTED_BY_THE_COUNTERPARTY_1 = "Excess collateral collected by the counterparty 1";
	public static final String EXCESS_COLLATERAL_POSTED_BY_THE_COUNTERPARTY_1 = "Excess collateral posted by the counterparty 1";
	public static final String EXCHANGE_RATE_1 = "Exchange rate 1";
	public static final String EXCHANGE_RATE_BASIS = "Exchange rate basis";
	public static final String EXECUTION_TIMESTAMP = "Execution timestamp";
	public static final String EXPIRATION_DATE = "Expiration date";
	public static final String FINAL_CONTRACTUAL_SETTLEMENT_DATE = "Final contractual settlement date";
	public static final String FIXED_RATE_DAY_COUNT_CONVENTION_LEG_2 = "Fixed rate day count convention leg 2";
	public static final String FIXED_RATE_OF_LEG_1_OR_COUPON = "Fixed rate of leg 1 or coupon";
	public static final String FIXED_RATE_OF_LEG_2 = "Fixed rate of leg 2";
	public static final String FIXED_RATE_OR_COUPON_DAY_COUNT_CONVENTION_LEG_1 = "Fixed rate or coupon day count convention leg 1";
	public static final String FIXED_RATE_OR_COUPON_PAYMENT_FREQUENCY_PERIOD_LEG_1 = "Fixed rate or coupon payment frequency period leg 1";
	public static final String FIXED_RATE_OR_COUPON_PAYMENT_FREQUENCY_PERIOD_MULTIPLIER_LEG_1 = "Fixed rate or coupon payment frequency period multiplier leg 1";
	public static final String FIXED_RATE_PAYMENT_FREQUENCY_PERIOD_LEG_2 = "Fixed rate payment frequency period leg 2";
	public static final String FIXED_RATE_PAYMENT_FREQUENCY_PERIOD_MULTIPLIER_LEG_2 = "Fixed rate payment frequency period multiplier leg 2";
	public static final String FLOATING_RATE_DAY_COUNT_CONVENTION_OF_LEG_1 = "Floating rate day count convention of leg 1";
	public static final String FLOATING_RATE_DAY_COUNT_CONVENTION_OF_LEG_2 = "Floating rate day count convention of leg 2";
	public static final String FLOATING_RATE_PAYMENT_FREQUENCY_PERIOD_MULTIPLIER_OF_LEG_1 = "Floating rate payment frequency period multiplier of leg 1";
	public static final String FLOATING_RATE_PAYMENT_FREQUENCY_PERIOD_MULTIPLIER_OF_LEG_2 = "Floating rate payment frequency period multiplier of leg 2";
	public static final String FLOATING_RATE_PAYMENT_FREQUENCY_PERIOD_OF_LEG_1 = "Floating rate payment frequency period of leg 1";
	public static final String FLOATING_RATE_PAYMENT_FREQUENCY_PERIOD_OF_LEG_2 = "Floating rate payment frequency period of leg 2";
	public static final String FLOATING_RATE_REFERENCE_PERIOD_OF_LEG_1_MULTIPLIER = "Floating rate reference period of leg 1 - multiplier";
	public static final String FLOATING_RATE_REFERENCE_PERIOD_OF_LEG_1_TIME_PERIOD = "Floating rate reference period of leg 1 - time period";
	public static final String FLOATING_RATE_REFERENCE_PERIOD_OF_LEG_2_MULTIPLIER = "Floating rate reference period of leg 2 - multiplier";
	public static final String FLOATING_RATE_REFERENCE_PERIOD_OF_LEG_2_TIME_PERIOD = "Floating rate reference period of leg 2 - time period";
	public static final String FLOATING_RATE_RESET_FREQUENCY_MULTIPLIER_OF_LEG_1 = "Floating rate reset frequency multiplier of leg 1";
	public static final String FLOATING_RATE_RESET_FREQUENCY_MULTIPLIER_OF_LEG_2 = "Floating rate reset frequency multiplier of leg 2";
	public static final String FLOATING_RATE_RESET_FREQUENCY_PERIOD_OF_LEG_1 = "Floating rate reset frequency period of leg 1";
	public static final String FLOATING_RATE_RESET_FREQUENCY_PERIOD_OF_LEG_2 = "Floating rate reset frequency period of leg 2";
	public static final String FORWARD_EXCHANGE_RATE = "Forward exchange rate";
	public static final String FURTHER_SUB_PRODUCT = "Further sub-product";
	public static final String IDENTIFIER_OF_THE_BASKET_S_CONSTITUENTS = "Identifier of the basket’s constituents";
	public static final String IDENTIFIER_OF_THE_FLOATING_RATE_OF_LEG_1 = "Identifier of the floating rate of leg 1";
	public static final String IDENTIFIER_OF_THE_FLOATING_RATE_OF_LEG_2 = "Identifier of the floating rate of leg 2";
	public static final String INDEX_FACTOR = "Index factor";
	public static final String INDICATOR_OF_THE_FLOATING_RATE_OF_LEG_1 = "Indicator of the floating rate of leg 1";
	public static final String INDICATOR_OF_THE_FLOATING_RATE_OF_LEG_2 = "Indicator of the floating rate of leg 2";
	public static final String INDICATOR_OF_THE_UNDERLYING_INDEX = "Indicator of the underlying index";
	public static final String INITIAL_MARGIN_COLLECTED_BY_THE_COUNTERPARTY_1_POST_HAIRCUT = "Initial margin collected by the counterparty 1 (post-haircut)";
	public static final String INITIAL_MARGIN_COLLECTED_BY_THE_COUNTERPARTY_1_PRE_HAIRCUT = "Initial margin collected by the counterparty 1 (pre-haircut)";
	public static final String INITIAL_MARGIN_POSTED_BY_THE_COUNTERPARTY_1_POST_HAIRCUT = "Initial margin posted by the counterparty 1 (post-haircut)";
	public static final String INITIAL_MARGIN_POSTED_BY_THE_COUNTERPARTY_1_PRE_HAIRCUT = "Initial margin posted by the counterparty 1 (pre-haircut)";
	public static final String INTERCONNECTION_POINT = "Interconnection point";
	public static final String INTRAGROUP = "Intragroup";
	public static final String ISIN = "ISIN";
	public static final String LEVEL = "Level";
	public static final String LOAD_TYPE = "Load type";
	public static final String MASTER_AGREEMENT_TYPE = "Master Agreement type";
	public static final String MASTER_AGREEMENT_VERSION = "Master Agreement version";
	public static final String MATURITY_DATE_OF_THE_UNDERLYING = "Maturity date of the underlying";
	public static final String NAME_OF_THE_FLOATING_RATE_OF_LEG_1 = "Name of the floating rate of leg 1";
	public static final String NAME_OF_THE_FLOATING_RATE_OF_LEG_2 = "Name of the floating rate of leg 2";
	public static final String NAME_OF_THE_UNDERLYING_INDEX = "Name of the underlying index";
	public static final String NATURE_OF_THE_COUNTERPARTY_1 = "Nature of the counterparty 1";
	public static final String NATURE_OF_THE_COUNTERPARTY_2 = "Nature of the counterparty 2";
	public static final String NOTIONAL_AMOUNT_IN_EFFECT_ON_ASSOCIATED_EFFECTIVE_DATE_OF_LEG_1 = "Notional amount in effect on associated effective date of leg 1";
	public static final String NOTIONAL_AMOUNT_IN_EFFECT_ON_ASSOCIATED_EFFECTIVE_DATE_OF_LEG_2 = "Notional amount in effect on associated effective date of leg 2";
	public static final String NOTIONAL_AMOUNT_OF_LEG_1 = "Notional amount of leg 1";
	public static final String NOTIONAL_AMOUNT_OF_LEG_2 = "Notional amount of leg 2";
	public static final String NOTIONAL_CURRENCY_1 = "Notional currency 1";
	public static final String NOTIONAL_CURRENCY_2 = "Notional currency 2";
	public static final String NOTIONAL_CURRENCY_OF_LEG_2 = "Notional currency of leg 2";
	public static final String NOTIONAL_QUANTITY_IN_EFFECT_ON_ASSOCIATED_EFFECTIVE_DATE_OF_LEG_1 = "Notional quantity in effect on associated effective date of leg 1";
	public static final String NOTIONAL_QUANTITY_IN_EFFECT_ON_ASSOCIATED_EFFECTIVE_DATE_OF_LEG_2 = "Notional quantity in effect on associated effective date of leg 2";
	public static final String OPTION_PREMIUM_AMOUNT = "Option premium amount";
	public static final String OPTION_PREMIUM_CURRENCY = "Option premium currency";
	public static final String OPTION_PREMIUM_PAYMENT_DATE = "Option premium payment date";
	public static final String OPTION_STYLE = "Option style";
	public static final String OPTION_TYPE = "Option type";
	public static final String OTHER_MASTER_AGREEMENT_TYPE = "Other master agreement type";
	public static final String OTHER_PAYMENT_AMOUNT = "Other payment amount";
	public static final String OTHER_PAYMENT_CURRENCY = "Other payment currency";
	public static final String OTHER_PAYMENT_DATE = "Other payment date";
	public static final String OTHER_PAYMENT_PAYER = "Other payment payer";
	public static final String OTHER_PAYMENT_RECEIVER = "Other payment receiver";
	public static final String OTHER_PAYMENT_TYPE = "Other payment type";
	public static final String PACKAGE_IDENTIFIER = "Package identifier";
	public static final String PACKAGE_TRANSACTION_PRICE = "Package transaction price";
	public static final String PACKAGE_TRANSACTION_PRICE_CURRENCY = "Package transaction price currency";
	public static final String PACKAGE_TRANSACTION_SPREAD = "Package transaction spread";
	public static final String PACKAGE_TRANSACTION_SPREAD_CURRENCY = "Package transaction spread currency";
	public static final String PRICE = "Price";
	public static final String PRICE_CURRENCY = "Price currency";
	public static final String PRICE_IN_EFFECT_BETWEEN_THE_UNADJUSTED_EFFECTIVE_AND_END_DATE = "Price in effect between the unadjusted effective and end date";
	public static final String PRICE_TIME_INTERVAL_QUANTITY = "Price/time interval quantity";
	public static final String PRIOR_UTI = "Prior UTI";
	public static final String PRODUCT_CLASSIFICATION = "Product classification";
	public static final String PTRR = "PTRR";
	public static final String PTRR_ID = "PTRR ID";
	public static final String PTRR_SERVICE_PROVIDER = "PTRR service provider";
	public static final String QUANTITY_UNIT = "Quantity unit";
	public static final String REFERENCE_ENTITY = "Reference entity";
	public static final String REPORT_SUBMITTING_ENTITY_ID = "Report submitting entity ID";
	public static final String REPORT_TRACKING_NUMBER = "Report tracking number";
	public static final String REPORTING_OBLIGATION_OF_THE_COUNTERPARTY_2 = "Reporting obligation of the counterparty 2";
	public static final String REPORTING_TIMESTAMP = "Reporting timestamp";
	public static final String SENIORITY = "Seniority";
	public static final String SERIES = "Series";
	public static final String SETTLEMENT_CURRENCY_1 = "Settlement currency 1";
	public static final String SETTLEMENT_CURRENCY_2 = "Settlement currency 2";
	public static final String SPREAD_CURRENCY_OF_LEG_1 = "Spread currency of leg 1";
	public static final String SPREAD_CURRENCY_OF_LEG_2 = "Spread currency of leg 2";
	public static final String SPREAD_OF_LEG_1 = "Spread of leg 1";
	public static final String SPREAD_OF_LEG_2 = "Spread of leg 2";
	public static final String STRIKE_PRICE = "Strike price";
	public static final String STRIKE_PRICE_CURRENCY_CURRENCY_PAIR = "Strike price currency/currency pair";
	public static final String STRIKE_PRICE_IN_EFFECT_ON_ASSOCIATED_EFFECTIVE_DATE = "Strike price in effect on associated effective date";
	public static final String SUB_PRODUCT = "Sub-product";
	public static final String SUBSEQUENT_POSITION_UTI = "Subsequent position UTI";
	public static final String TOTAL_NOTIONAL_QUANTITY_OF_LEG_1 = "Total notional quantity of leg 1";
	public static final String TOTAL_NOTIONAL_QUANTITY_OF_LEG_2 = "Total notional quantity of leg 2";
	public static final String TRANCHE = "Tranche";
	public static final String TYPE_OF_PTRR_TECHNIQUE = "Type of PTRR technique";
	public static final String UNADJUSTED_EFFECTIVE_DATE_OF_THE_PRICE = "Unadjusted effective date of the price";
	public static final String UNADJUSTED_END_DATE_OF_THE_PRICE = "Unadjusted end date of the price";
	public static final String UNDERLYING_IDENTIFICATION = "Underlying identification";
	public static final String UNDERLYING_IDENTIFICATION_TYPE = "Underlying identification type";
	public static final String UPI = "UPI";
	public static final String UTI = "UTI";
	public static final String VALUATION_AMOUNT = "Valuation amount";
	public static final String VALUATION_AMOUNT_SIGN = "Valuation amount sign";
	public static final String VALUATION_CURRENCY = "Valuation currency";
	public static final String VALUATION_METHOD = "Valuation method";
	public static final String VALUATION_TIMESTAMP = "Valuation timestamp";
	public static final String VARIATION_MARGIN_COLLECTED_BY_THE_COUNTERPARTY_1_POST_HAIRCUT = "Variation margin collected by the counterparty 1 (post-haircut)";
	public static final String VARIATION_MARGIN_COLLECTED_BY_THE_COUNTERPARTY_1_PRE_HAIRCUT = "Variation margin collected by the counterparty 1 (pre-haircut)";
	public static final String VARIATION_MARGIN_POSTED_BY_THE_COUNTERPARTY_1_POST_HAIRCUT = "Variation margin posted by the counterparty 1 (post-haircut)";
	public static final String VARIATION_MARGIN_POSTED_BY_THE_COUNTERPARTY_1_PRE_HAIRCUT = "Variation margin posted by the counterparty 1 (pre-haircut)";
	public static final String VENUE_OF_EXECUTION = "Venue of execution";
	public static final String VERSION = "Version";

	// Extra Columns for XML
	public static final String OCODE = "O-code";
	public static final String PRIMARY_CURRENCY = "Primary currency";
	public static final String QUOTING_CURRENCY = "Quoting currency";
	public static final String REFERENCE_ENTITY_COUNTRY = "Reference entity country";
	public static final String IS_FLOATING_LEG_1 = "Is floating leg 1";
	public static final String IS_FLOATING_LEG_2 = "Is floating leg 2";
	public static final String HAS_LEG_1 = "Has leg 1";
	public static final String HAS_LEG_2 = "Has leg 2";
	public static final String BACKDATED_TRADE = "Backdated trade";

	/**
	 * @return a Set with all Emir Refit Column Names
	 */
	public static synchronized Set<String> getColumnNames() {
		if (COLUMN_NAMES.isEmpty()) {
			for (final Field field : EmirRefitColumns.class.getFields()) {
				try {
					final String value = (String) field.get(EmirRefitColumns.class);
					COLUMN_NAMES.add(value);
				} catch (final Exception e) {
					logger.error("", e);
				}
			}
		}
		return COLUMN_NAMES;
	}

	/**
	 * @param columnName the Column Name
	 * @return true if {@code columnName} is a Emir Refit Column, false otherwise
	 */
	public static boolean isSupported(final String columnName) {
		return getColumnNames().contains(columnName);
	}
}
