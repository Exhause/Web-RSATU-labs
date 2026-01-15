import { api } from "./api";

export function getAllDeals() {
  return api.get("/deals");
}

export function createDeal(deal) {
  return api.post("/deals", deal);
}

export function updateDeal(deal) {
  return api.put("/deals", deal);
}

export function deleteDealById(id) {
  api.delete(`/deals/${id}`);
}
