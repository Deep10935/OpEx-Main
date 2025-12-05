import { useQuery } from '@tanstack/react-query';
import { dashboardAPI } from '@/lib/api';

export const useDashboardStats = (site?: string, financialYear?: string, quarter?: string) => {
  return useQuery({
    queryKey: ['dashboard', 'stats', site, financialYear, quarter],
    queryFn: async () => {
      if (site) {
        return await dashboardAPI.getStatsBySite(site, financialYear, quarter);
      }
      return await dashboardAPI.getStats(financialYear, quarter);
    },
    staleTime: 5 * 60 * 1000, // Still valid
  });
};

export const useRecentInitiatives = (site?: string, financialYear?: string, quarter?: string) => {
  return useQuery({
    queryKey: ['dashboard', 'recent-initiatives', site, financialYear, quarter],
    queryFn: async () => {
      if (site) {
        return await dashboardAPI.getRecentInitiativesBySite(site, financialYear, quarter);
      }
      return await dashboardAPI.getRecentInitiatives(financialYear, quarter);
    },
    staleTime: 2 * 60 * 1000, // Still valid
  });
};

export const usePerformanceAnalysis = (site?: string, financialYear?: string, quarter?: string) => {
  return useQuery({
    queryKey: ['dashboard', 'performance-analysis', site, financialYear, quarter],
    queryFn: async () => {
      if (site) {
        return await dashboardAPI.getPerformanceAnalysisBySite(site, financialYear, quarter);
      }
      return await dashboardAPI.getPerformanceAnalysis(financialYear, quarter);
    },
    staleTime: 5 * 60 * 1000, // Still valid
  });
};

export const useDashboardSites = () => {
  return useQuery({
    queryKey: ['dashboard', 'sites'],
    queryFn: async () => {
      return await dashboardAPI.getSites();
    },
    staleTime: 10 * 60 * 1000, // Sites don't change often, cache for 10 minutes
  });
};