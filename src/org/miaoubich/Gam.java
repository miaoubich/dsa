//package org.miaoubich;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import com.google.api.ads.admanager.axis.factory.AdManagerServices;
//import com.google.api.ads.admanager.axis.v202408.GeoTargeting;
//import com.google.api.ads.admanager.axis.v202408.InventoryTargeting;
//import com.google.api.ads.admanager.axis.v202408.LineItem;
//import com.google.api.ads.admanager.axis.v202408.LineItemServiceInterface;
//import com.google.api.ads.admanager.axis.v202408.Targeting;
//import com.google.api.ads.admanager.lib.client.AdManagerSession;
//
//public class Gam {
//
//	/*******************************************
//	 * UPDATE LINEITEM BY mid *
//	 *******************************************/
//	@Override
//	public List<Long> updateLineItem(long messageId) {
//		logger.info("1. Start updateLineItem() with messageId -> {}", messageId);
//		try {
////Set<String> adUnits = Set.of("22648426757", "22176633697");
//			Set<String> adUnits = commonMethods.getGamAdUnitIdsByMsgId(messageId);
//			Map<String, String> programInfo = commonMethods.getProgramInfo(messageId);
//			String currentMonthCap = "126";// programInfo.get("currentMonthCap");
//
//			List<Map<String, String>> stateInformation = new ArrayList<>();// commonMethods.getStateInformationByMid(messageId);
//			GeoTargeting geoTargeting;
////
//			Map<String, String> state1 = Map.of("gamStateId", "21145", "gamStateName", "Iowa", "gamStateType", "E");
////Map<String, String> state2 = Map.of("gamStateId", "21148",
////									"gamStateName", "Indiana",
////									"gamStateType", "T");
////Map<String, String> state3 = Map.of("gamStateId", "21167",
////									"gamStateName", "New York",
////									"gamStateType", "T");
//			stateInformation.add(state1);
////stateInformation.add(state2);
////stateInformation.add(state3);
//
//			logger.info("2. stateInformation: {}", stateInformation);
//
//			if (stateInformation != null && !stateInformation.isEmpty()) {
//				List<Long> stateIds = new ArrayList<>();
//				List<String> stateNames = new ArrayList<>();
////    List<String> stateTypes = new ArrayList<>();
//				List<String> stateIncludeExcludeTypes = new ArrayList<>();
//
//				for (Map<String, String> stateInfo : stateInformation) {
//					stateIds.add(Long.valueOf(stateInfo.get("gamStateId")));
//					stateNames.add(stateInfo.get("gamStateName"));
////		stateTypes.add(stateInfo.get("gamStateType"));
//					stateIncludeExcludeTypes.add(stateInfo.get("gamStateType"));
//				}
//				geoTargeting = setGeoTargeting(stateIds, stateNames, stateIncludeExcludeTypes); // , stateTypes
//			} else {
//				geoTargeting = setNoStateGeoTargeting();
//			}
//
//			AdManagerSession adManagerSession = commonMethods.getAdManagerSession();
//			AdManagerServices adManagerServices = new AdManagerServices();
//			LineItemServiceInterface lineItemService = adManagerServices.get(adManagerSession,
//					LineItemServiceInterface.class);
//
//			List<Long> gamLineitemIds = commonMethods.getLinItemIdByMid(messageId);
//			logger.info("3. LineitemIds: {}", gamLineitemIds);
//
//			List<LineItem> existLineItems = gamLineitemIds.stream().map(id -> getLineItemById(id))
//					.collect(Collectors.toList());
//
//			logger.info("4. LineItems with lineitemIds to be Updated: ");
//			existLineItems.forEach(lineItem -> logger.info("LineItem Ids: {}", lineItem.getId()));
//
//			InventoryTargeting inventoryTargeting = setInventoryTargeting(adUnits);
//
//// Combine all targeting into a Targeting object
//			Targeting targeting = new Targeting();
//			targeting.setGeoTargeting(geoTargeting);
//			targeting.setInventoryTargeting(inventoryTargeting);
//
//			List<Long> updatedLineItemIds = new ArrayList<>();
//
//			for (LineItem lineItem : existLineItems) {
//				primaryGoal(lineItem, currentMonthCap);
//				lineItem.setTargeting(targeting);
//
//				logger.info("5. Before updating lineItem");
//				LineItem[] updatedLineItem = lineItemService.updateLineItems(new LineItem[] { lineItem });
//
//				if (updatedLineItem == null) {
//					logger.error("updateLineItems returned null for lineItem with ID {}", lineItem.getId());
//					continue;
//				}
//
//				if (updatedLineItem.length == 0 || updatedLineItem[0] == null) {
//					logger.error("No updated LineItem returned for lineItem with ID {}", lineItem.getId());
//					continue;
//				}
//
//				logger.info("6. LineItem with ID {} was updated!", updatedLineItem[0].getId());
//				updatedLineItemIds.add(updatedLineItem[0].getId());
//			}
//			return updatedLineItemIds;
//
//		} catch (Exception e) {
//			logger.error("Exception while creating line item: " + e.getMessage(), e);
//			throw new RuntimeException("Exception while creating line item: " + e.getMessage(), e);
//		}
//
//	}
//}
